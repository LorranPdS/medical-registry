package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequest(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotNull
        Integer idade) {
}
