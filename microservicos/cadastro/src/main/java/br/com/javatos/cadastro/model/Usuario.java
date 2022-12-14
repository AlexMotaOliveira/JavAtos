package br.com.javatos.cadastro.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Column(unique = true)
    private String email;
    @CPF
    @Column(unique = true)
    private String cpf;
    @NotBlank
    private String senha;

    @OneToMany
    List<Produtos> produtosList = new ArrayList<>();


}
