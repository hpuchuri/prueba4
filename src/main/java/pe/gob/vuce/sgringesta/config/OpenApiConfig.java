/**
 * @author: Leonardo Ivan Torres Ochoa [31/05/2021]
 * @updated: 31/05/2021
 * @description: Centro de Demarcacion Territorial SDOT/PCM
 * @since-version: 1.0
 * @email: leonardotorres@adiera.com
 * @web: www.adieraservices.com
 */
package pe.gob.vuce.sgringesta.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
    description = "VUCE Sgr Ingesta de datos",
    version = "1.0", title = "VUCE-INGESTA 1.0", contact = @Contact(name = "leonardotorres@adiera.com")))
public class OpenApiConfig {

}
