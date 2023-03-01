package br.com.javatos.usuario.service;

import br.com.javatos.usuario.model.Usuario;
import br.com.javatos.usuario.repository.UsuarioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;

  public List<Usuario> buscarTodos() {
    return this.usuarioRepository.findAll();
  }

  public Usuario buscarUsuarioId(Long id) {
    return (Usuario)this.usuarioRepository.findById(id).orElse(new Usuario());
  }

  public Usuario salvarUsuario(Usuario usuario) {
    return (Usuario)this.usuarioRepository.save(usuario);
  }

  public void apagarUsuario(Long id) {
    this.usuarioRepository.deleteById(id);
  }

  public UsuarioService(final UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }
}
