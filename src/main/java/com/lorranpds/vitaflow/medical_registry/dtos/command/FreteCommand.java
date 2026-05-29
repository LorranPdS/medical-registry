package com.lorranpds.vitaflow.medical_registry.dtos.command;

import com.lorranpds.vitaflow.medical_registry.services.TipoFrete;

import java.math.BigDecimal;
import java.util.EnumSet;

public record FreteCommand(
        EnumSet<TipoFrete> tiposFrete,
        BigDecimal pesoEmKg,
        BigDecimal distanciaEmKm
) {
}
