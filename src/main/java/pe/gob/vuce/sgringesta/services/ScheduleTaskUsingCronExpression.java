package pe.gob.vuce.sgringesta.services;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pe.gob.vuce.sgringesta.model.IngestaDatosRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static pe.gob.vuce.sgringesta.util.LibrariesApp.getDateFormat01;
import static pe.gob.vuce.sgringesta.util.LibrariesApp.readJson;


@Slf4j
@Service
public class ScheduleTaskUsingCronExpression {

    @Autowired
    IngestaWSServiceImpl ingestaWSServiceImpl;

    @Autowired
    private IngestaDatosService ingestaDatosService;

    @Scheduled(cron = "0 */1 * ? * *")
    public void scheduleTaskingestaDatosGet() throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        log.info("Current time is hp:: " + getDateFormat01() );
        //
        JSONArray jsonArray = ingestaWSServiceImpl.listarWSDatosIngesta();
        try {
            for(int i=0;i<jsonArray.size();i++){
                JSONObject field = (JSONObject)jsonArray.get(i); // Exception happens here.
                IngestaDatosRequest payloadIngesta = readJson(field.get("cuerpo").toString());
                log.info("DatosPost ingesta", payloadIngesta);
                ingestaDatosService.ingestaDatosPost(payloadIngesta);
                log.info("colaIngestaID hp:: " + field.get("colaIngestaID").toString() );
                ingestaWSServiceImpl.actualizaColaIngesta(field.get("colaIngestaID").toString());

            }

        } catch (Exception e) {
            log.error(e.getMessage());
            //return new ResponseEntity<ApiMessageResponse>(new ApiMessageResponse("ERROR", "INGESTA_DATOS", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
