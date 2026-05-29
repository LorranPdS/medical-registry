package com.lorranpds.vitaflow.medical_registry.strategies;

import com.lorranpds.vitaflow.medical_registry.services.TipoFrete;
import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// Strategy 4: Retirada na Loja (sempre gratuita)
@Component
public class FreteRetiradaNaLoja implements FreteStrategy {

    @Override
    public TipoFrete getTipoFrete() {
        return TipoFrete.RETIRADA_LOJA;
    }

    @Override
    public BigDecimal calcular(BigDecimal pesoEmKg, BigDecimal distanciaEmKm) {
        return BigDecimal.ZERO;
    }
}
