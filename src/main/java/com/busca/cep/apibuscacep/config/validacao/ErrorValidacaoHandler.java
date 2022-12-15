package com.busca.cep.apibuscacep.config.validacao;

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
public class ErrorValidacaoHandler {
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorValidacaoDto> handle(MethodArgumentNotValidException exception) {
        List<ErrorValidacaoDto> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(errorMessage -> {
            String mensagem = messageSource.getMessage(errorMessage, LocaleContextHolder.getLocale());
            ErrorValidacaoDto erro = new ErrorValidacaoDto(errorMessage.getField(), mensagem);
            dto.add(erro);
        });

        return dto;
    }

}
