package br.com.javatos.web.controller;

import br.com.javatos.web.model.Usuario;
import br.com.javatos.web.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/usuario")
    public String abrirPagina(ModelMap modelMap) {
        modelMap.addAttribute("usuario", new Usuario());
        return "usuario/cadastro-usuario";
    }

    @PostMapping("/usuario")
    public String cadastrar(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "usuario/cadastro-usuario";
        }
        usuarioService.salvar(usuario);

        return "redirect:/tarefa"; // passar uma URI
    }
}
