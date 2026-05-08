package com.lorranpds.vitaflow.medical_registry.exceptions;

import java.time.LocalDateTime;

public record DefaultErrorResponse(String message, LocalDateTime timestamp) {

    public DefaultErrorResponse(String msg){
        this(msg, LocalDateTime.now());
    }
}
