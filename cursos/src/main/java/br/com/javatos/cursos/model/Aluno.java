package br.com.javatos.cursos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String cpf;
    private String email;
    private String matricula;

    @Embedded
    private Endereco endereco;

    @ManyToMany
    private List<Curso> cursos;

    @ManyToMany
    private List<Nota> notas;
}
