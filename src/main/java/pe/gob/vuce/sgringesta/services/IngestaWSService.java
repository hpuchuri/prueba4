package pe.gob.vuce.sgringesta.services;

import org.json.simple.JSONArray;
import pe.gob.vuce.sgringesta.dto.GenericDTO;

import java.io.IOException;

public interface IngestaWSService extends GenericService<GenericDTO>{

    JSONArray listarWSDatosIngesta() throws IOException;
    void actualizaColaIngesta(String cola_ingesta_id) throws IOException ;

}
