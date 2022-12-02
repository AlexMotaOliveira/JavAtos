package br.com.javatos.cursos.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@ApiModel(value = "CursoCDF", description = "classe modelo para um Curso")
//@ApiIgnore
@Builder
public class Curso {
    //fisica
    //pedagogia

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(example = "Engenharia de Computação")
    @NotNull
    @Size(min = 2, max = 50)
    private String nome;
    private String codigo;

    @ManyToMany
    private List<Disciplina> disciplinas; // portugues

}
