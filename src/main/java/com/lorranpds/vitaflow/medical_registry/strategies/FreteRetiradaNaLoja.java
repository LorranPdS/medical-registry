package com.lorranpds.vitaflow.medical_registry.strategies;

import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;

// Strategy 4: Retirada na Loja (sempre gratuita)
public class FreteRetiradaNaLoja implements FreteStrategy {

    @Override
    public double calcular(double pesoEmKg, double distanciaEmKm) {
        return 0.0;
    }
}
