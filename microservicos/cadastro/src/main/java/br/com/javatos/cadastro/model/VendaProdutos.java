package br.com.javatos.cadastro.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class VendaProdutos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataVenda;
    private BigDecimal valorTotal;

    @ManyToMany
    List<Produtos> produtosList;

}
