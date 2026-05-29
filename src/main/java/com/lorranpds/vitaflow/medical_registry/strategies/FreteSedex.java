package com.lorranpds.vitaflow.medical_registry.strategies;

import com.lorranpds.vitaflow.medical_registry.services.TipoFrete;
import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// Strategy 2: Sedex (mais rápido, mais caro)
@Component
public class FreteSedex implements FreteStrategy {

    @Override
    public TipoFrete getTipoFrete() {
        return TipoFrete.SEDEX;
    }

    @Override
    public BigDecimal calcular(BigDecimal pesoEmKg, BigDecimal distanciaEmKm) {
        // Regra: Taxa fixa de R$ 25,00 + R$ 1,20 por kg + R$ 0,30 por km

        BigDecimal taxaFixa = BigDecimal.valueOf(25.00);
        BigDecimal valorPorKg = pesoEmKg.multiply(BigDecimal.valueOf(1.2));
        BigDecimal valorPorKm = distanciaEmKm.multiply(BigDecimal.valueOf(0.3));

        return taxaFixa.add(valorPorKg).add(valorPorKm);
    }
}
