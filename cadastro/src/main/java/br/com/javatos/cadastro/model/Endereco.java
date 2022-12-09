package br.com.javatos.cadastro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Endereco {
    public String cep;
    @JsonProperty(value = "logradouro")
    public String rua;
    public String complemento;
    public String bairro;
    //localidade
    @JsonProperty(value = "localidade")
    public String cidade;
    public String uf;
}
