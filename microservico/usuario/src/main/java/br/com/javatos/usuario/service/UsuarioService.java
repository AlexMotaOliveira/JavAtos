package br.com.javatos.usuario.service;

import br.com.javatos.usuario.model.Email;
import br.com.javatos.usuario.model.Usuario;
import br.com.javatos.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioService {

  private final String URL = "http://localhost:8085/email";

  private final UsuarioRepository usuarioRepository;
  private final RestTemplate restTemplate;
  private final SendEmail sendEmail;

  public Page<Usuario> buscarTodos(String nome, Pageable pageable) {
    return usuarioRepository.findByNomeContainingIgnoreCase(nome, pageable);
  }

  public Usuario buscarUsuarioId(Long id) {
    return usuarioRepository.findById(id).orElse(new Usuario());
  }

  public Usuario salvarUsuario(Usuario usuario) {
    Usuario usuarioEntity = usuarioRepository.save(usuario);
    // apos o cadastro, enviar um email

    Email email = Email.builder()
      .emailTo(usuario.getEmail())
      .emailFrom("alexmotadev@gmail.com")
      .subject(usuario.getNome())
      .text("Seja Bem vindo " + usuario.getNome() + " , para acessar o site ")
      .build();

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Email> request = new HttpEntity<>(email, httpHeaders);

    try {
      Email response = restTemplate.postForObject(URL, request, Email.class);
      log.info("envio deleteById email ok: {}", response);
    } catch (RuntimeException e) {
      log.error("{}", e);
    }

    return usuarioEntity;
  }

  public void apagarUsuario(Long id) {
    this.usuarioRepository.deleteById(id);
  }


  public Usuario atualizarUsuario(Usuario usuario) {
    Usuario usuarioEntity = usuarioRepository.save(usuario);

    Email email = Email.builder()
      .emailTo(usuario.getEmail())
      .emailFrom("alexmotadev@gmail.com")
      .subject(usuario.getNome())
      .text("Seja Bem vindo " + usuario.getNome() + " , para acessar o site ")
      .build();

    sendEmail.enviar(email);
    return usuarioEntity;

  }
}
