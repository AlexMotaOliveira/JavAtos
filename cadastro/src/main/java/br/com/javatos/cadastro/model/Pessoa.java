package br.com.javatos.cadastro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Entity
@Table(name = "tb_Pessoa")
@Data
@JsonInclude(NON_NULL)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "v_nome_completo", length = 300, nullable = false)
    @NotBlank(message = "campo não pode ser nulo")
    @Size(min = 2, max = 300, message = "nome invalido")
    private String nome;

    @Column(name = "v_email", length = 200, nullable = false, unique = true)
    @Email(message = "email informado invalido")
    private String email;

    @Column(name = "v_cpf", length = 11, nullable = false, unique = true)
//    @CPF(message = "cpf informado invalido")
    private String cpf;

    @Column(nullable = false) //TODO inserir com formato br e validar a inserção
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR")
    private Date dataDeNascimento;

    @Column(nullable = false, unique = true, updatable = false)
    @JsonIgnore // não exibe essa informação no response
    private String matricula = UUID.randomUUID().toString();

    @CreationTimestamp
    @JsonIgnore // não exibe essa informação no response
    private Date dataDoCadatro;

    //    @OneToMany // 1:N
    //    @ManyToOne // N:1
    //    @ManyToMany// N:N
    //    @OneToOne  // 1:1
    @Embedded
    Endereco endereco;

}
