package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto;

public record PatientRegistrationResponse(
        String recordId,
        String statusMessage
){}