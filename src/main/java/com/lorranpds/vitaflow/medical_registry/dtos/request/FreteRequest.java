package com.lorranpds.vitaflow.medical_registry.dtos.request;

import com.lorranpds.vitaflow.medical_registry.services.TipoFrete;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.EnumSet;

public record FreteRequest(
        @NotNull
        EnumSet<TipoFrete> tiposFrete,

        @NotNull(message = "O valor não pode ser nulo")
        @DecimalMin(value = "0.0000001", message = "O valor não pode ser nulo ou zero")
        BigDecimal pesoEmKg,

        @NotNull(message = "O valor não pode ser nulo")
        @DecimalMin(value = "0.01", message = "O valor não pode ser nulo ou zero")
        BigDecimal distanciaEmKm
        ) {
}
