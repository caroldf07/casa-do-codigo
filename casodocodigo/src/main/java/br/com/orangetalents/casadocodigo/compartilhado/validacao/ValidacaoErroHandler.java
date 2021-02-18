package br.com.orangetalents.casadocodigo.compartilhado.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidacaoErroHandler {

    @Autowired
    MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidacaoErro> handle(MethodArgumentNotValidException exception) {

        List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();

        List<ValidacaoErro> validacaoErros = new ArrayList<>();

        fieldError.forEach(erro -> {
            String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
            ValidacaoErro validacaoErro = new ValidacaoErro(erro.getField(), mensagem);

            validacaoErros.add(validacaoErro);
        });

        return validacaoErros;

    }
}
