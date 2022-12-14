package br.com.javatos.cadastro.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigoProduto;
    private String unidadeMedida; // kg, unidade
    private String valorUnitario;

    @ManyToOne
    private Marca marca;
    @ManyToOne
    private Categoria categoria;


}
