package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.user;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotBlank
        String nome,

        @NotNull
        @Min(value = 18, message = "Idade não pode ser inferior a {value} anos")
        Integer idade,

        @NotBlank
        String email) {
}
