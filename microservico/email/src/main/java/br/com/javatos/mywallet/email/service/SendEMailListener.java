package br.com.javatos.mywallet.email.service;


import br.com.javatos.mywallet.email.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendEMailListener {

  @Autowired
  private EmailService emailService;

  @RabbitListener(queues = "lancamento.enviar") // consumer
  public void listener(@Payload Email email) {
    log.info("paylod: {}", email);
    emailService.enviarEmail(email);
  }
}
