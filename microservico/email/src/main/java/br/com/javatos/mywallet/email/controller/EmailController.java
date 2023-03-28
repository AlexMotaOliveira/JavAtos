package br.com.javatos.mywallet.email.controller;


import br.com.javatos.mywallet.email.model.Email;
import br.com.javatos.mywallet.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/email")
@RestController
public class EmailController {

  @Autowired
  public EmailService emailService;

  @PostMapping
  public Email enviarEmail(@RequestBody Email email) {
    return emailService.enviarEmail(email);
  }
}
