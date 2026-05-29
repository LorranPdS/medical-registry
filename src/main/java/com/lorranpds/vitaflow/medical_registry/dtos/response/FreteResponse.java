package com.lorranpds.vitaflow.medical_registry.dtos.response;

import com.lorranpds.vitaflow.medical_registry.services.TipoFrete;

import java.math.BigDecimal;

public record FreteResponse(TipoFrete tipoFrete, BigDecimal valor) {
}
