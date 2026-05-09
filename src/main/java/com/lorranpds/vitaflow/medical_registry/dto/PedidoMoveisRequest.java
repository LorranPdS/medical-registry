package com.lorranpds.vitaflow.medical_registry.dto;

import com.lorranpds.vitaflow.medical_registry.enums.EstiloMoveis;
import jakarta.validation.constraints.NotNull;

public record PedidoMoveisRequest(
        @NotNull(message = "Field 'estilo' must be filled")
        EstiloMoveis estilo
) {}
