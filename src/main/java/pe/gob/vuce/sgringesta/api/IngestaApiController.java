/**
 * @author: Leonardo Ivan Torres Ochoa [06/03/2022]
 * @updated: 06/03/2022
 * @description: VUCE Middleware para Sistema de Gestion de Riesgos
 * @since-version: 1.0
 * @email: leonardotorres@adiera.com
 * @web: www.adieraservices.com
 */
package pe.gob.vuce.sgringesta.api;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import pe.gob.vuce.sgringesta.entity.ColaIngesta;
import pe.gob.vuce.sgringesta.entity.ColaIngestaRepository;
import pe.gob.vuce.sgringesta.model.ApiMessageResponse;
import pe.gob.vuce.sgringesta.model.IngestaDatosRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import pe.gob.vuce.sgringesta.services.IngestaDatosService;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pe.gob.vuce.sgringesta.util.LibrariesApp.updateJson;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-06T01:24:38.459Z[GMT]")
@RestController
public class IngestaApiController implements IngestaApi {

    private static final Logger log = LoggerFactory.getLogger(IngestaApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final ColaIngestaRepository colaIngestaRepository;

    @Autowired
    private IngestaDatosService ingestaDatosService;

    @org.springframework.beans.factory.annotation.Autowired
    public IngestaApiController(ObjectMapper objectMapper, HttpServletRequest request, ColaIngestaRepository colaIngestaRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.colaIngestaRepository = colaIngestaRepository;
    }

    public ResponseEntity<?> ingestaDatosPost(@Parameter(in = ParameterIn.HEADER, description = "Apikey" ,required=false,schema=@Schema()) @RequestHeader(value="apikey", required=false) String apikey,@Parameter(in = ParameterIn.HEADER, description = "Ambiente de despliegue" ,required=true,schema=@Schema()) @RequestHeader(value="Host", required=true) String host,@Parameter(in = ParameterIn.DEFAULT, description = "Datos de procedimiento", required=true, schema=@Schema()) @Valid @RequestBody IngestaDatosRequest body) {
        String accept = "Accept"; //request.getHeader("Accept");
        List<ColaIngesta> objectList = getObjectList();
        //IngestaDatosRequest ingesta = new IngestaDatosRequest();
        if (accept != null) {
            try {
                objectList.forEach(field -> {
                    //pruebas con equipo
                    //String jsonew = field.getCuerpo();
                    //jsonew=jsonew.replace("\\\"mensaje_id\\\":11129248", "\\\"mensaje_id\\\":11129249").replace("\\\"notificacion_id\\\":100638", "\\\"notificacion_id\\\":100509");
                    //IngestaDatosRequest payloadIngesta = readJson(jsonew);
                    //fin
                    IngestaDatosRequest payloadIngesta = readJson2(field.getCuerpo());
                    //IngestaDatosRequest payloadIngesta = readJsonold(field.getCuerpo());
                    log.info("DatosPost ingesta", payloadIngesta);
                    ingestaDatosService.ingestaDatosPost(payloadIngesta);
                });
                return new ResponseEntity<Void>(HttpStatus.OK);
            } catch (Exception e) {
                log.error(e.getMessage());
                return new ResponseEntity<ApiMessageResponse>(new ApiMessageResponse("ERROR", "INGESTA_DATOS", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    private List<ColaIngesta> getObjectList(){
        ArrayList<ColaIngesta> objectList = null;
        List<ColaIngesta> colaIngesta = null;
        colaIngesta = colaIngestaRepository.getList();
        objectList = new ArrayList<>(colaIngesta);

        return objectList;
    }

    public IngestaDatosRequest readJson2(String fileJson){
        IngestaDatosRequest ingesta = new IngestaDatosRequest();
        JSONParser parser = new JSONParser();
        final ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapFromString = new HashMap<>();
        try {
            //mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
            mapper.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(),true);
            //mapper.configure(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature(),true);
            mapFromString = mapper.readValue(fileJson, new TypeReference<Map<String, Object>>() {});
            JSONObject config = new JSONObject(mapFromString);
            //--add campos
            ingesta.setTabla((String) config.get("tabla"));
            ingesta.setTipo((String) config.get("tipo"));
            ingesta.setFechaGeneracion((String) config.get("fecha_generacion"));
            Map<String, Object> datosMap = mapper.readValue(updateJson((String) config.get("datos")),
                    new TypeReference<Map<String, Object>>() {});
            ingesta.setDatos(new JSONObject(datosMap));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingesta;
    }

}
