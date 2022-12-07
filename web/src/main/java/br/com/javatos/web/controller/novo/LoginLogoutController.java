package br.com.javatos.web.controller.novo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginLogoutController {

    @GetMapping("/login")
    public String login() {
        //TODO validar se o usuario já esta logado e redircionar para outra pagina
        return "login";
    }

    @GetMapping("login-error")
    public String loginError(Model model) {
        model.addAttribute("mensagem", "senha ou email invalidos");
        return "login";
    }
}
