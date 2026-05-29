package com.lorranpds.vitaflow.medical_registry.strategies;

import com.lorranpds.vitaflow.medical_registry.services.TipoFrete;
import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// Strategy 1: PAC - mais barato, mais demorado
@Component
public class FretePAC implements FreteStrategy {

    @Override
    public TipoFrete getTipoFrete() {
        return TipoFrete.PAC;
    }

    @Override
    public BigDecimal calcular(BigDecimal pesoEmKg, BigDecimal distanciaEmKm) {
        // Regra: Taxa fixa de R$ 10,00 + R$ 0,50 por kg + R$ 0,10 por km

        BigDecimal taxaFixa = BigDecimal.valueOf(10.00);
        BigDecimal valorPorKg = pesoEmKg.multiply(BigDecimal.valueOf(0.5));
        BigDecimal valorPorKm = distanciaEmKm.multiply(BigDecimal.valueOf(0.1));

        return taxaFixa.add(valorPorKg).add(valorPorKm);
    }
}
