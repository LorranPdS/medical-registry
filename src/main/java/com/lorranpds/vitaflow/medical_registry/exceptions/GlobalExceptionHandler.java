package com.lorranpds.vitaflow.medical_registry.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DefaultErrorResponse> handleInvalidOrInexistentEnum() {
        String mensagem = "The notification type specified does not exist or is invalid.";
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new DefaultErrorResponse(mensagem));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<DefaultErrorResponse> handleFactoryNotCompletelyImplemented(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new DefaultErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultErrorResponse> handleTypeNull(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult()
                .getFieldErrors()
                .getFirst()
                .getDefaultMessage();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DefaultErrorResponse(message));
    }

    /* TODO:
        1) Verificar como que faz para que seja possível retornar uma lista de erros
        - pelo que o Gemini me disse, se os dois campos que estão vindo pelo request
            estiverem vindo errados, vai mostrar apenas um por vez
        - pelo que ele me falou, a experiência do usuário seria melhor se viesse uma
            lista de erros, ou seja, mostraria o erro dos dois campos
     */

}