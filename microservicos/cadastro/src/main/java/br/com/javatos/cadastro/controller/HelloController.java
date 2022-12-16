package br.com.javatos.cadastro.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
@Slf4j
public class HelloController {


    @GetMapping
    public String get(){
        log.info("***** Chamou aqui ******");
        return "microservico de cadastro";
    }
}
