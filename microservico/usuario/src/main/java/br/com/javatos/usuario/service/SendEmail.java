package br.com.javatos.usuario.service;

import br.com.javatos.usuario.model.Email;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "email", path = "/email")
public interface SendEmail {

  @PostMapping
  Email enviar(Email email);

//  @GetMapping
//  Email excluir();

}
