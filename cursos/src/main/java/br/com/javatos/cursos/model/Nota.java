package br.com.javatos.cursos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double valor;
    private String tipo;

    @ManyToMany
    private List<Disciplina> disciplinas; // Composição

    //Augusto passou por aqui

}
