package br.com.javatos.usuario.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
//    registry
//      .addMapping("/**")
//      .allowedOrigins("http://localhost:9000")
//      .allowedMethods("GET", "POST", "DELETE", "OPTIONS");
    // TODO: 07/03/2023 liberação de cors realizada no frontend 
  }
}
