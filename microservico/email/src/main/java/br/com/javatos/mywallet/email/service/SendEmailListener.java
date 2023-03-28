package br.com.javatos.mywallet.email.service;


import br.com.javatos.mywallet.email.config.RabbitConfig;
import br.com.javatos.mywallet.email.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendEmailListener {

  @Autowired
  private EmailService emailService;

  @Autowired
  private RunnerRabbit runnerRabbit;


  @RabbitListener(queues = RabbitConfig.CRIAR) // consumer padrão são 10*5ms
  public void listenerCriar(@Payload Email email) {
    runnerRabbit.run(() -> {
      log.info("paylod Criar: {}", email);
      emailService.enviarEmail(email);
    });
  }

  @RabbitListener(queues = RabbitConfig.ALTERAR) // consumer
  public void listenerAlterar(@Payload Email email) {
    log.info("paylod Alterar: {}", email);
    emailService.enviarEmail(email);
  }

  @RabbitListener(queues = RabbitConfig.EXCLUIR) // consumer
  public void listenerExcluir(@Payload Email email) {
    log.info("paylod Excluir: {}", email);
    emailService.enviarEmail(email);
  }
}
