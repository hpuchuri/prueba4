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
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
       .antMatchers("/sgr/api-docs/**", "/sgr/api-ui.html", "/sgr/swagger-ui/**", "/sgr/swagger-ui.html").permitAll()
       .anyRequest().permitAll();
    http.csrf().disable();
  }
}
