package com.lorranpds.vitaflow.medical_registry.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(

        @NotBlank(message = "O nome é obrigatório")
        String nome,
        String pais,
        String idioma,
        boolean ativo,
        boolean isBrasil) {
}
