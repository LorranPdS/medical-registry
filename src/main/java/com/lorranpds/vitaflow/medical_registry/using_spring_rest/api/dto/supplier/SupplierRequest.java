package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.supplier;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record SupplierRequest(
        @NotBlank
        String nome,

        @NotBlank
        String endereco,

        @Min(value = 2, message = "O limite de dias para recebimento não pode ser inferior a {value} dias")
        Integer limiteDiasParaRecebimento) {
}