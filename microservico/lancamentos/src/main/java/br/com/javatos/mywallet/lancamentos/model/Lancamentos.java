package br.com.javatos.mywallet.lancamentos.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Lancamentos {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Code;

  private String tipo;
  private String local;
  private String descricao;
  private String dataDaCompra;
  private String dataDeVencimento;
  private BigDecimal valor;

}
