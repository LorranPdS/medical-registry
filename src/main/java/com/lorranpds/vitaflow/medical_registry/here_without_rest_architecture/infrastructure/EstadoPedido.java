package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.services.Pedido;

// 1. Interface State
public interface EstadoPedido {
    // Comportamento padrão: se o estado não reescrever o metodo, a ação é bloqueada.
    default void pagar(Pedido pedido) {
        throw new IllegalStateException("Ação 'Pagar' não permitida no estado atual para o pedido [id={}]." + pedido.getId());
    }
    default void cancelar(Pedido pedido) {
        throw new IllegalStateException("Ação 'Cancelar' não permitida no estado atual para o pedido [id={}]." + pedido.getId());
    }
    default void enviar(Pedido pedido) {
        throw new IllegalStateException("Ação 'Enviar' não permitida no estado atual para o pedido [id={}]." + pedido.getId());
    }
    default void entregar(Pedido pedido) {
        throw new IllegalStateException("Ação 'Entregar' não permitida no estado atual para o pedido [id={}]." + pedido.getId());
    }
}
