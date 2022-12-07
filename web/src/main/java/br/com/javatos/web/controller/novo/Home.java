package br.com.javatos.web.controller.novo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Home {

    @GetMapping
    public String getHome(){
        return "index";
    }

}
