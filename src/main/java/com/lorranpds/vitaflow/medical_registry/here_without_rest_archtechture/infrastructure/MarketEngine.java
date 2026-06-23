package com.lorranpds.vitaflow.medical_registry.here_without_rest_archtechture.infrastructure;

// 2. O Receiver (A Regra de Negócio Real)
public class MarketEngine {

    public void executeBuy(String ticker, int quantity) {
        // Lógica complexa: valida saldo, bloqueia margem, envia para a B3...
        System.out.println("[MARKET ENGINE] Executando COMPRA de " + quantity + " cotas de " + ticker);
    }

    public void executeSell(String ticker, int quantity) {
        // Lógica complexa: valida custódia, calcula imposto retido, envia para a B3...
        System.out.println("[MARKET ENGINE] Executando VENDA de " + quantity + " cotas de " + ticker);
    }
}
