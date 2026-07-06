package com.lorranpds.vitaflow.medical_registry.using_spring_rest.dto;

import jakarta.validation.constraints.NotBlank;

// DTO de Entrada para o metodo PUT
public record ArtigoRequest(
        @NotBlank(message = "O título não pode ser vazio")
        String titulo,

        @NotBlank(message = "O texto não pode ser vazio")
        String texto
) {}
