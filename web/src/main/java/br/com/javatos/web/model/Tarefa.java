package br.com.javatos.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //null   primitivo= 0

    @NotBlank(message = "insira uma descrição")
    @Size(min = 5, max = 50)
    @Column(length = 50, nullable = false)
    private String descricao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "informe uma data futura para a tarefa")
    @Column(updatable = false, nullable = false)
    private Date prazo;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(updatable = false, nullable = false)
    private Date dataInicial;
}
