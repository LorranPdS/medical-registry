package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

// 1. A Interface de transição
public interface OperacoesPedido {

    default StatusPedido pagar() {
        throw new IllegalStateException("Não é possível pagar neste estado.");
    }

    default StatusPedido cancelar() {
        throw new IllegalStateException("Não é possível cancelar neste estado.");
    }

    default StatusPedido enviar() {
        throw new IllegalStateException("Não é possível enviar neste estado.");
    }

    default StatusPedido entregar() {
        throw new IllegalStateException("Não é possível entregar neste estado.");
    }

    // Por padrão, nenhum estado precisa de estorno
    default boolean exigeEstorno() {
        return false;
    }
}
