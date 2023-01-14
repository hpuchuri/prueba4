/**
 * @author: Leonardo Ivan Torres Ochoa [06/03/2022]
 * @updated: 06/03/2022
 * @description: VUCE Middleware para Sistema de Gestion de Riesgos
 * @since-version: 1.0
 * @email: leonardotorres@adiera.com
 * @web: www.adieraservices.com
 */
package pe.gob.vuce.sgringesta.api;

import pe.gob.vuce.sgringesta.model.ApiMessageResponse;
import pe.gob.vuce.sgringesta.model.IngestaDatosRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-06T01:24:38.459Z[GMT]")
@Validated
public interface IngestaApi {

    @Operation(summary = "", description = "", tags={ "Ingesta de Datos" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Operacion Exitosa"),
        @ApiResponse(responseCode = "400", description = "Datos invalidos en el requerimiento", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiMessageResponse.class))),
        @ApiResponse(responseCode = "401", description = "El requerimiento no es autorizado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiMessageResponse.class))),
        @ApiResponse(responseCode = "500", description = "Servicio con problemas", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiMessageResponse.class))),
        @ApiResponse(responseCode = "503", description = "Servicio no disponible", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiMessageResponse.class))) })
    @RequestMapping(value = "/ingestaDatos",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<?> ingestaDatosPost(@Parameter(in = ParameterIn.HEADER, description = "Apikey" ,required=true,schema=@Schema()) @RequestHeader(value="apikey", required=true) String apikey, @Parameter(in = ParameterIn.HEADER, description = "Ambiente de despliegue" ,required=true,schema=@Schema()) @RequestHeader(value="host", required=true) String host,@Parameter(in = ParameterIn.DEFAULT, description = "Datos de procedimiento", required=true, schema=@Schema()) @Valid @RequestBody IngestaDatosRequest body);

}

