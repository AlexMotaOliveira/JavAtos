package br.com.javatos.cursos.config;

import br.com.javatos.cursos.service.AlunoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.javatos.cursos.controller2"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        Contact contact = new
                Contact("Alex mota",
                "https://github.com/AlexMotaOliveira/gama-projeto-java/blob/main/Diagrama%20entidades.png",
                "Alex@alex.com");

        ApiInfo apiInfo =
                new ApiInfoBuilder()
                        .title("API de cadastro de aluno")
                        .description("Essa Api faz o cadastro, listagem, exclusão de um aluno ou um curso ")
                        .version("1.0.0")
                        .license("Apache ")
                        .licenseUrl("localhos:8080")
                        .contact(contact)
                        .build();
        return apiInfo;
    }
}
