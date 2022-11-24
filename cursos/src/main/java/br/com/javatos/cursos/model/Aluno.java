package br.com.javatos.cursos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ApiModel(value = "AlunoCDF", description = "classe modelo para um Aluno")
//@ApiIgnore
@Builder
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(example = "Alex Mota")
    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @ApiModelProperty(example = "12312312312", required = true)
    @CPF
    private String cpf;

    @ApiModelProperty(example = "alex@alex.com", required = true)
    @Column(unique = true,length = 200)
    private String email;

    @ApiModelProperty(example = "12356985")
    private String matricula;

    @Embedded
    @ApiModelProperty(required = true)
    private Endereco endereco;

    @ManyToMany
    @JsonIgnore
    private List<Curso> cursos = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    private List<Nota> notas = new ArrayList<>();
}
