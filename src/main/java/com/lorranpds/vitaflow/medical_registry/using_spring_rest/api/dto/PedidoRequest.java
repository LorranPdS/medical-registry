package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PedidoRequest(@NotNull UUID idPedido) {
}
