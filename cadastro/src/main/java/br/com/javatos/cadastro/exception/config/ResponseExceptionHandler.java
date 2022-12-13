package br.com.javatos.cadastro.exception.config;

import br.com.javatos.cadastro.exception.errors.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

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

    @ExceptionHandler({InternalException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResponseError handlerError(InternalException e) {
        return RestResponseError.pessoaNotFoundException(e.getMessage());
    }

    @ExceptionHandler({BadArgumentsException.class, ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResponseError handlerError(BadArgumentsException e) {
        return RestResponseError.pessoaNotFoundException(e.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestResponseError handlerError(ResourceNotFoundException e) {
        return RestResponseError.pessoaNotFoundException(e.getMessage());
    }
}
