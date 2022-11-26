package br.com.javatos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHome(ModelMap modelMap) {
        modelMap.addAttribute("hello", "ola minha pagina com o spring web");
        return "index";
    }
}
