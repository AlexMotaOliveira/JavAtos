package br.com.javatos.usuario.controller;

import br.com.javatos.usuario.model.Usuario;
import br.com.javatos.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//@CrossOrigin
@RestController
@RequestMapping({"/"})
public class UsuarioController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping
  public Page<Usuario> filtrarNome(@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
                                   Pageable pageable) {

    return usuarioService.buscarTodos(nome, pageable);
  }


  @GetMapping({"/email/{email}"})  // /usuario/{id}
  public Usuario buscarUsuarioEmail(@PathVariable String email) {
    return this.usuarioService.buscarUsuarioEmail(email);
  }

  @GetMapping({"/{id}"})  // /usuario/{id}
  public Usuario buscarUsuarioId(@PathVariable Long id) {
    return this.usuarioService.buscarUsuarioId(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Usuario salvarUsuario(@RequestBody @Valid Usuario usuario) {
    return this.usuarioService.salvarUsuario(usuario);
  }

//  @CrossOrigin
  @DeleteMapping({"/{id}"})// /id   != /{id}
  @ResponseStatus(HttpStatus.NO_CONTENT)
  //localhost:8081/usuario/12     //localhost:8081/usuario?id=12
  public void apagarUsuario(@PathVariable Long id) {
    this.usuarioService.apagarUsuario(id);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Usuario atualizarUsuario(@RequestBody @Valid Usuario usuario) {
    return this.usuarioService.atualizarUsuario(usuario);
  }
}
