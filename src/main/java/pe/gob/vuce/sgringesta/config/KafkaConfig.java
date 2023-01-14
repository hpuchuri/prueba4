/**
 * @author: Leonardo Ivan Torres Ochoa [31/05/2021]
 * @updated: 31/05/2021
 * @description: Centro de Demarcacion Territorial SDOT/PCM
 * @since-version: 1.0
 * @email: leonardotorres@adiera.com
 * @web: www.adieraservices.com
 */
package pe.gob.vuce.sgringesta.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;
import pe.gob.vuce.sgringesta.model.IngestaDatosRequest;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Value(value="${vuce.sgringesta.kafka-bootstrap-server}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory<String, IngestaDatosRequest> producerFactory()
    {
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,  bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, IngestaDatosRequest> kafkaTemplate() {
        return new KafkaTemplate<>(this.producerFactory());
    }

}
