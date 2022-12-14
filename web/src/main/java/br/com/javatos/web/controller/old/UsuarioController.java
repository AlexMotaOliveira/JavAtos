package br.com.javatos.web.controller.old;

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
        return "register";
    }

    @PostMapping
    public String cadastrar(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        String senhaCriptrografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptrografada);
        usuario.getRoles().add(new Roles(2L, Role.ADMIN));
        usuarioService.salvar(usuario);
        return "redirect:/tarefa"; // passar uma URI
    }

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
        return "register";
    }
}
