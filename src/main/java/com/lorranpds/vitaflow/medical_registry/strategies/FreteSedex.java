package com.lorranpds.vitaflow.medical_registry.strategies;

import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;

// Strategy 2: Sedex (mais rápido, mais caro)
public class FreteSedex implements FreteStrategy {

    @Override
    public double calcular(double pesoEmKg, double distanciaEmKm) {
        // Regra: Taxa fixa de R$ 25,00 + R$ 1,20 por kg + R$ 0,30 por km
        return 25.00 + (pesoEmKg * 1.20) + (distanciaEmKm * 0.30);
    }
}
