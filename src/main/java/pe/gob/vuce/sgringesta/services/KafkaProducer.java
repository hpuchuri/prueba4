/**
 * @author: Leonardo Ivan Torres Ochoa [06/03/2022]
 * @updated: 06/03/2022
 * @description: VUCE Middleware para Sistema de Gestion de Riesgos
 * @since-version: 1.0
 * @email: leonardotorres@adiera.com
 * @web: www.adieraservices.com
 */
package pe.gob.vuce.sgringesta.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pe.gob.vuce.sgringesta.model.IngestaDatosRequest;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@Service
public class KafkaProducer {
    @Value(value="${vuce.sgringesta.topic-ingesta-request}")
    private String ingestaTopic;

    @Autowired
    KafkaTemplate<String, IngestaDatosRequest> kafkaTemplate;

    public void writeMessage(@Valid IngestaDatosRequest request) {
        log.info("Kafka Producer:{}", request.toString());
        kafkaTemplate.send(ingestaTopic, UUID.randomUUID().toString(),request);
    }

}
