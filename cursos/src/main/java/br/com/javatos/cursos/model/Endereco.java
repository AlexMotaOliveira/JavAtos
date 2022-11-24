package br.com.javatos.cursos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Endereco {

    @JsonProperty("logradouro")
    private String rua;
    @ApiModelProperty(example = "123", required = true)
    private Integer numero;
    private String complemento;
    @ApiModelProperty(example = "03590170", required = true)
    private String cep;
    private String uf;
    @JsonProperty(value = "localidade")
    private String cidade;

}
