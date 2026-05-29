package com.lorranpds.vitaflow.medical_registry.strategies;

import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;

// Strategy 1: PAC - mais barato, mais demorado
public class FretePAC implements FreteStrategy {

    @Override
    public double calcular(double pesoEmKg, double distanciaEmKm) {
        // Regra: Taxa fixa de R$ 10,00 + R$ 0,50 por kg + R$ 0,10 por km
        return 10.00 + (pesoEmKg * 0.50) + (distanciaEmKm * 0.10);
    }
}
