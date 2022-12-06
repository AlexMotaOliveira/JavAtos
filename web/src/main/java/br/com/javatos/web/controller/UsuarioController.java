package br.com.javatos.web.controller;

import br.com.javatos.web.model.Role;
import br.com.javatos.web.model.Roles;
import br.com.javatos.web.model.Usuario;
import br.com.javatos.web.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String abrirPagina(ModelMap modelMap) {
        modelMap.addAttribute("usuario", new Usuario());
        return "usuario/cadastro-usuario";
    }

    @PostMapping
    public String cadastrar(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "usuario/cadastro-usuario";
        }
        String senhaCriptrografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptrografada);
        usuario.getRoles().add(new Roles(2L, Role.ADMIN));
        usuarioService.salvar(usuario);
        return "redirect:/tarefa"; // passar uma URI
    }

    //$2a$10$SN0Ivp1SlcrHvLcSUcIejugiyPYH6JJipFUHk7vd69CVZ128PVY/O

    @GetMapping("/listar")
    public String buscarTodos(Model model) {
        List<Usuario> list = usuarioService.buscarTodos();
        model.addAttribute("usuarios", list);
        return "usuario/lista-usuario";
    }

    @RequestMapping(method = {RequestMethod.DELETE, RequestMethod.POST}, value = "/excluir")
    public String excluir(Long id) {
        usuarioService.excluir(id);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/{id}")
    public String buscarTodos(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscar(id);
        model.addAttribute("usuario", usuario);
        return "usuario/cadastro-usuario";
    }
}
