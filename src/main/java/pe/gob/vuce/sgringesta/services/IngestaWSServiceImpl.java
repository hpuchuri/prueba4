package pe.gob.vuce.sgringesta.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.jboss.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import pe.gob.vuce.sgringesta.constants.ConstantesError;
import pe.gob.vuce.sgringesta.constants.ConstantesGenerales;
import pe.gob.vuce.sgringesta.exception.ServiceException;

import java.io.IOException;

@Slf4j
@Service
public class IngestaWSServiceImpl implements IngestaWSService {
    Logger logger= Logger.getLogger(IngestaWSServiceImpl.class);

    @Override
    public JSONArray listarWSDatosIngesta() throws IOException {
        String path = ConstantesGenerales.URI_PROXY_COMMON_HOSTNAME_LOCAL + ConstantesGenerales.URI_PROXY_COMMON_SERVICE + ConstantesGenerales.URI_PROXY_COMMON_METHOD_LISTA_INGESTA;
        logger.info("Path:" +path);
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(path);
        get.setHeader(ConstantesGenerales.NWS_HEADER_CONTENT, ConstantesGenerales.NWS_HEADER_CONTENT_VALUE);
        HttpResponse response = client.execute(get);
        if(HttpStatus.OK.value() != response.getStatusLine().getStatusCode()) {
            throw new ServiceException(ConstantesError.ERR_WS_PROXY_COMMON);
        }
        //add array
        String jsonString = EntityUtils.toString(response.getEntity(), ConstantesGenerales.UTF8);
        JSONParser jsonParser=new  JSONParser();
        JSONArray jObj =new JSONArray();
        if ((jsonString != null) && !(jsonString.isEmpty())) {
            try {
                jObj = (JSONArray) jsonParser.parse(jsonString);
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
        }
        return jObj;

    }

    @Override
    public void actualizaColaIngesta(String cola_ingesta_id) throws IOException {
        String path = ConstantesGenerales.URI_PROXY_COMMON_HOSTNAME_LOCAL + ConstantesGenerales.URI_PROXY_COMMON_SERVICE + ConstantesGenerales.URI_PROXY_COMMON_METHOD_UPDATE_INGESTA;
        logger.info("Path:" +path);
        HttpClient client = HttpClientBuilder.create().build();
        //HttpGet get = new HttpGet(path);
        //get.setHeader(ConstantesGenerales.NWS_HEADER_CONTENT, ConstantesGenerales.NWS_HEADER_CONTENT_VALUE);
        HttpPost post = new HttpPost(path);
        post.setHeader(ConstantesGenerales.NWS_HEADER_CONTENT, ConstantesGenerales.NWS_HEADER_CONTENT_VALUE);

        JSONObject message = new JSONObject();
        message.put("colaIngestaId", cola_ingesta_id);
        message.put("fechaEnvio", "2022-12-21 14:44:44");
        message.put("estadoApi", "2");
        message.put("codigoEstado","400");
        message.put("mensaje", "");
        message.put("fechaRespuesta", "2022-12-21 14:44:44");

        post.setEntity(new StringEntity(message.toString(), ConstantesGenerales.UTF8));

        HttpResponse response = client.execute(post);
        if(HttpStatus.OK.value() != response.getStatusLine().getStatusCode()) {
            throw new ServiceException(ConstantesError.ERR_WS_PROXY_COMMON);
        }
        //add array
        String jsonString = EntityUtils.toString(response.getEntity(), ConstantesGenerales.UTF8);
        JSONParser jsonParser=new  JSONParser();
        JSONArray jObj =new JSONArray();
        if ((jsonString != null) && !(jsonString.isEmpty())) {
            try {
                jObj = (JSONArray) jsonParser.parse(jsonString);
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
        }
       // return jObj;

    }


 }
