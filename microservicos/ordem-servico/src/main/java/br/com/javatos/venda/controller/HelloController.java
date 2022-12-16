package br.com.javatos.venda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class HelloController {


    @GetMapping
    public String get(){
        return "microservico order-service";
    }
}
