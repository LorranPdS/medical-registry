package com.lorranpds.vitaflow.medical_registry.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Trata erro de conversão de Enum (O erro que você recebeu)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DefaultErrorResponse> handleInvalidEnum(HttpMessageNotReadableException ex) {
        String mensagem = "The notification type specified does not exist or is invalid.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultErrorResponse(mensagem));
    }

    // Trata o erro que você lançou manualmente no Service
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<DefaultErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultErrorResponse(ex.getMessage()));
    }
}