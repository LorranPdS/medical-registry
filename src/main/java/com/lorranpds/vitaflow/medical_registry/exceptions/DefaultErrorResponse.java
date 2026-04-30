package com.lorranpds.vitaflow.medical_registry.exceptions;

/*
    Foi dado o nome "DefaultErrorResponse" em vez de "ErrorResponse" porque,
    ao usar essa record na classe GlobalExceptionHandler, com o nome "ErrorResponse",
    ele conflitava com o import "org.springframework.web.ErrorResponse".

    Removendo o import já resolvia o problema e a classe GlobalExceptionHandler já identificava
    essa record aqui, mas renomear essa record evidencia mais que estou tratando um response
    com uma classe que foi criada no meu projeto.
 */
public record DefaultErrorResponse(String message) {
}
