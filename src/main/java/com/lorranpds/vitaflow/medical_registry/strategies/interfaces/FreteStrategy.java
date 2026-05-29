package com.lorranpds.vitaflow.medical_registry.strategies.interfaces;

import com.lorranpds.vitaflow.medical_registry.services.TipoFrete;

import java.math.BigDecimal;

public interface FreteStrategy {
    TipoFrete getTipoFrete();

    BigDecimal calcular(BigDecimal pesoEmKg, BigDecimal distanciaEmKm);
}
