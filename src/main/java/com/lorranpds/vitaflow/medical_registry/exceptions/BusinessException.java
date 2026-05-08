package com.lorranpds.vitaflow.medical_registry.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message){
        super(message);
    }
}
