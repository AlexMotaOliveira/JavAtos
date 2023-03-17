package br.com.javatos.mywallet.lancamentos.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Lancamento {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long code;

  @NotBlank
  private String tipo;

  @NotBlank
  private String local;

  @NotBlank
  private String descricao;

  @NotBlank
  private LocalDate dataDaCompra;
  @NotBlank
  private LocalDate dataDeVencimento;

  @Min(0)
  private BigDecimal valor;

}
