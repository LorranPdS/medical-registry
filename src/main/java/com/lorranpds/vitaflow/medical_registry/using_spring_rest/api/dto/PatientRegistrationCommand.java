package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto;

public record PatientRegistrationCommand(
        String fullName,
        String document,
        String email
) {
}
