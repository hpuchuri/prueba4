package pe.gob.vuce.sgringesta.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.vuce.sgringesta.exception.ServiceException;
import pe.gob.vuce.sgringesta.model.IngestaDatosRequest;
import javax.validation.Valid;


@Slf4j
@Service
@RequiredArgsConstructor
public class IngestaDatosService {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    IngestaWSServiceImpl ingestaWSServiceImpl;

    public void ingestaDatosPost(@Valid IngestaDatosRequest ingesta) throws ServiceException {
        log.info("ingresa al kafka");
        kafkaProducer.writeMessage(ingesta);
    }

}
