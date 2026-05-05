package com.lorranpds.vitaflow.medical_registry.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Trata erro de conversão de Enum: ao executar o POSTMAN, colocar um ENUM inexistente
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DefaultErrorResponse> handleInvalidEnum(HttpMessageNotReadableException ex) { // TODO: colocar esse parâmetro na implementação
        String mensagem = "The notification type specified does not exist or is invalid.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultErrorResponse(mensagem));
    }

    // Trata o erro lançado manualmente no Service: caso tenha incluído o ENUM mas não tenha implementado os métodos de fábrica para ele
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<DefaultErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultErrorResponse(ex.getMessage()));
    }

    /* TODO:
        1) melhorar a mensagem de erro se eu escrever o nome do campo errado no JSON vindo do POSTMAN.
            Ex.: "typE" em vez de "type"

        2) melhorar mensagem de erro se eu colocar o campo como null no JSON

        3) colocar limite de tamanho nos campos para String
     */

}