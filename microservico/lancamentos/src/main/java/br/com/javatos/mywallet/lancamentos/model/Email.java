package br.com.javatos.mywallet.lancamentos.model;


import br.com.javatos.mywallet.lancamentos.enums.EmailStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Email {

  private long id;
  private String messageId;
  private String emailFrom;
  private String emailTo;
  private String subject;
  private String text;
  private LocalDateTime localDateTime;
  private EmailStatus emailStatus;

}
