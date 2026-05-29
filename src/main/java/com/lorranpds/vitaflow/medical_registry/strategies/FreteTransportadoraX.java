package com.lorranpds.vitaflow.medical_registry.strategies;

import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;

// Strategy 3: Transportadora X (focada em longas distâncias)
public class FreteTransportadoraX implements FreteStrategy {

    @Override
    public double calcular(double pesoEmKg, double distanciaEmKm) {
        // Regra: Taxa fixa de R$ 18,00 + R$ 0,20 por km (não cobra pelo peso)
        return 18.00 + (distanciaEmKm * 0.20);
    }
}
