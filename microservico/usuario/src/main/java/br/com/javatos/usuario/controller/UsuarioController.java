package br.com.javatos.usuario.controller;

import br.com.javatos.usuario.model.Usuario;
import br.com.javatos.usuario.service.UsuarioService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/usuario"})
@CrossOrigin
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping
  public List<Usuario> buscarTodos() {
    return this.usuarioService.buscarTodos();
  }

  @GetMapping({"/{id}"})
  public Usuario buscarUsuarioId(@PathVariable Long id) {
    return this.usuarioService.buscarUsuarioId(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Usuario salvarUsuario(@RequestBody @Valid Usuario usuario) {
    return this.usuarioService.salvarUsuario(usuario);
  }

  @DeleteMapping({"/id"})
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void apagarUsuario(@PathVariable Long id) {
    this.usuarioService.apagarUsuario(id);
  }
}
