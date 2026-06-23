package com.lorranpds.vitaflow.medical_registry.here_without_rest_archtechture.infrastructure;

import java.util.ArrayList;
import java.util.List;

// 4. O Invoker (O Gerenciador da Corretora)
public class BrokerQueue {
    private final List<OrderCommand> orderQueue = new ArrayList<>();

    // Apenas recebe o comando e guarda. Não executa ainda.
    public void takeOrder(OrderCommand order) {
        orderQueue.add(order);
        System.out.println("[BROKER] Ordem recebida e enfileirada para auditoria/processamento.");
    }

    // Processa a fila no momento adequado (ex: abertura do mercado)
    public void processOrders() {
        System.out.println("--- Iniciando processamento da fila de ordens ---");
        for (OrderCommand order : orderQueue) {
            order.execute();
        }
        orderQueue.clear();
    }
}
