package com.lorranpds.vitaflow.medical_registry.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PedidoRequest {

    @NotEmpty
    private String numeroPedido;
    @NotEmpty
    private String cliente;
    private boolean entregaExpressa;
    private String observacao;
}
