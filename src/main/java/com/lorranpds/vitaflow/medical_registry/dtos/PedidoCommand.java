package com.lorranpds.vitaflow.medical_registry.dtos;

public record PedidoCommand(String numeroPedido, String cliente, boolean entregaExpressa, String observacao) {
}
