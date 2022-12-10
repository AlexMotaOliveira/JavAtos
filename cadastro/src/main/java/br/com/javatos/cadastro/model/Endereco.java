package br.com.javatos.cadastro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @NotBlank
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
