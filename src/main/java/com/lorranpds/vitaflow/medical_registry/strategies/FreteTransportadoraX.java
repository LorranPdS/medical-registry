package com.lorranpds.vitaflow.medical_registry.strategies;

import com.lorranpds.vitaflow.medical_registry.services.TipoFrete;
import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// Strategy 3: Transportadora X (focada em longas distâncias)
@Component
public class FreteTransportadoraX implements FreteStrategy {

    @Override
    public TipoFrete getTipoFrete() {
        return TipoFrete.TRANSPORTADORA_X;
    }

    @Override
    public BigDecimal calcular(BigDecimal pesoEmKg, BigDecimal distanciaEmKm) {
        // Regra: Taxa fixa de R$ 18,00 + R$ 0,20 por km (não cobra pelo peso)

        BigDecimal taxaFixa = BigDecimal.valueOf(18.00);
        BigDecimal valorPorKm = distanciaEmKm.multiply(BigDecimal.valueOf(0.2));
        return taxaFixa.add(valorPorKm);
    }
}
