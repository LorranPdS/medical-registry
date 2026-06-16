package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.service;

import java.util.UUID;

public interface PedidoServiceInterface {

    void realizarPagamento(UUID pedidoId);

    void enviarPedido(UUID pedidoId);

    void cancelarPedido(UUID pedidoId);
}
