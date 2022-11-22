package br.com.javatos.cadastro.exception.config;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponseError {
    private String error;
    public static RestResponseError pessoaNotFoundException(String mensagem) {
        RestResponseError rest = new RestResponseError();
        rest.error = mensagem;
        return rest;
    }
}
