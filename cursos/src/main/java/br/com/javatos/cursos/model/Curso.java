package br.com.javatos.cursos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Curso {
    //fisica
    //pedagogia

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String codigo;

    @ManyToMany
    private List<Disciplina> disciplinas; // portugues

}
