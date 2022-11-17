package br.com.javatos.model;

import lombok.*;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "tb_aluno")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

}
