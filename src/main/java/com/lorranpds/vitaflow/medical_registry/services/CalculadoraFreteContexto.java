package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;

public class CalculadoraFreteContexto {

    private FreteStrategy freteStrategy;

    // Injeta ou altera a estratégia em tempo de execução
    public void setStrategy(FreteStrategy estrategia){
        this.freteStrategy = estrategia;
    }

    public double executarCalculo(double peso, double distancia){
        if (freteStrategy == null) {
            throw new IllegalStateException("Por favor, selecione uma modalidade de frete antes de calcular.");
        }
        // O contexto delega a execução para a estratégia ativa
        return freteStrategy.calcular(peso, distancia);
    }
}
