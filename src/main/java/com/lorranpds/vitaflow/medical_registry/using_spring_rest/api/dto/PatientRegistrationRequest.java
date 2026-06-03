package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto;

public record PatientRegistrationRequest(
        String fullName,
        String document,
        String email
){}