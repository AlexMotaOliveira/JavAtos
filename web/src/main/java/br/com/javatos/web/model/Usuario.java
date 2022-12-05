package br.com.javatos.web.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome não pode ser nulo")
    @Column(length = 200, nullable = false)
    @Size(min = 2, max = 200)
    private String nome;

    @NotBlank(message = "email não pode ser nulo")
    @Email
    @Column(length = 100, nullable = false, unique = true)
    @Size(min = 2, max = 100)
    private String email;


    @CPF
    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @NotBlank(message = "senha não pode ser nula")
//    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\s]).{8,}$",
//            message = "min 8, max 20, uma minsuacula, uma maiscula, um numero, um caracter especial")
    @Column(length = 20, nullable = false)
    @Size(min = 8, max = 20)
    private String senha;

}
