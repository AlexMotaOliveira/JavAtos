package br.com.javatos.cadastro.exception.config;

import br.com.javatos.cadastro.exception.errors.DuplicacaoCadastroException;
import br.com.javatos.cadastro.exception.errors.PessoaExceptionNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(PessoaExceptionNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestResponseError handlerError(PessoaExceptionNotFound e) {
        return RestResponseError.pessoaNotFoundException(e.getMessage());
    }

    @ExceptionHandler(DuplicacaoCadastroException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public RestResponseError handlerError(DuplicacaoCadastroException e) {
        return RestResponseError.pessoaNotFoundException(e.getMessage());
    }
}
