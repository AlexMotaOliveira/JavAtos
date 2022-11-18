package br.com.javatos.cadastro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_Pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "v_nome_completo", length = 300, nullable = false)
    @NotBlank(message = "campo não pode ser nulo")
    @Size(min = 2, max = 300, message = "nome invalido")
    private String nome;

    @Column(name = "v_email", length = 200, nullable = false)
    @Email(message = "email informado invalido")
    private String email;

    @Column(name = "v_cpf", length = 11, nullable = false, unique = true)
    @CPF(message = "cpf informado invalido")
    private String cpf;

    @Column(nullable = false) //TODO inserir com formato br e validar a inserção
    @Past
    private Date dataDeNascimento;

    @Column(nullable = false, unique = true)
    private String matricula = UUID.randomUUID().toString();

    @CreationTimestamp
    private Date dataDoCadatro;

}
