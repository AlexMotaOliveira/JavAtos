package br.com.javatos.cursos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
// TODO alteração...


    @Bean
    public Docket api() {

        List<ResponseMessage> listMessage = new ArrayList<>();
        listMessage.add(new ResponseMessageBuilder().code(200).message("sucesso !!!").build());
        listMessage.add(new ResponseMessageBuilder().code(400).message("erro seu, envie os dados corretos").build());
        listMessage.add(new ResponseMessageBuilder().code(401).message("você não tem permissão").build());
        listMessage.add(new ResponseMessageBuilder().code(403).message("você não pode acessar esse recurso").build());
        listMessage.add(new ResponseMessageBuilder().code(500).message("entre em contato com o administrador").build());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.javatos.cursos.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, listMessage)
                .globalResponseMessage(RequestMethod.POST, listMessage)
                .globalResponseMessage(RequestMethod.PUT, listMessage)
                .globalResponseMessage(RequestMethod.DELETE, listMessage);
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
