package br.com.javatos.usuario.service;

import br.com.javatos.usuario.model.Usuario;
import br.com.javatos.usuario.repository.UsuarioRepository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
  private final UsuarioRepository usuarioRepository;

  public Page<Usuario> buscarTodos(String nome, Pageable pageable) {
    return this.usuarioRepository.findByNomeContainingIgnoreCase(nome, pageable);
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
