package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.customer;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CustomerRequest(
        @NotBlank
        String nome,

        @NotBlank
        String endereco,

        @NotNull(message = "Limite de crédito é obrigatório")
        @DecimalMin(value = "2000.0", message = "Limite de crédito não pode ser inferior a 2.000")
        BigDecimal limiteCredito) {
}