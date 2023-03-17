package br.com.javatos.mywallet.email.service;

import br.com.javatos.mywallet.email.enums.EmailStatus;
import br.com.javatos.mywallet.email.model.Email;
import br.com.javatos.mywallet.email.repository.EmailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class EmailService {

  @Autowired
  private EmailRepository emailRepository;

  @Autowired
  private JavaMailSender javaMailSender;

  public Email enviarEmail(Email email) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    String messageId = UUID.randomUUID().toString();
    email.setMessageId(messageId);
    try {
      mailMessage.setFrom(email.getEmailFrom());
      mailMessage.setTo(email.getEmailTo());
      mailMessage.setSubject(email.getSubject());
      mailMessage.setText(email.getText());

      // enviar um email
      log.info("{} enviando email", messageId);
      javaMailSender.send(mailMessage);
      log.info("{} email enviado", messageId);
      email.setEmailStatus(EmailStatus.ENVIADO);
    } catch (MailException e) {
      email.setEmailStatus(EmailStatus.FALHA);
      log.error("{} falha no envio de email", messageId);
      log.error("{}", messageId, e);
    } finally {
      // salvar o email no BD

      Email save = emailRepository.save(email);
      log.info("{} email salvo no bd: {}", messageId, save);
      return save;
    }
  }
}
