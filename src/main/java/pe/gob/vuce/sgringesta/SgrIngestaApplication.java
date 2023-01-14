package pe.gob.vuce.sgringesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;




@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//@SpringBootApplication()
@EnableScheduling
public class SgrIngestaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgrIngestaApplication.class, args);
	}

}
