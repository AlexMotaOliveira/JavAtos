package br.com.javatos.mywallet.email.model;


import br.com.javatos.mywallet.email.enums.EmailStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.core.annotation.Order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "EMAIL_TABLE")
public class Email {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String messageId;
  private String emailFrom;
  private String emailTo;
  private String subject;
  private String text;
  @CreationTimestamp
  private LocalDateTime localDateTime;
  private EmailStatus emailStatus;

}
