package br.com.javatos.cursos.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Endereco {

    @JsonProperty("logradouro")
    private String rua;
    private Integer numero;
    private String complemento;
    private String cep;
    private String uf;
    @JsonProperty(value = "localidade")
    private String cidade;

}
