package br.com.javatos.mywallet.lancamentos.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Data
public class Lancamento {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Code;

  @NotBlank
  private String tipo;

  @NotBlank
  private String local;

  @NotBlank
  private String descricao;

  @NotBlank
  private String dataDaCompra;

  @NotBlank
  private String dataDeVencimento;

  @Min(0)
  private BigDecimal valor;

}
