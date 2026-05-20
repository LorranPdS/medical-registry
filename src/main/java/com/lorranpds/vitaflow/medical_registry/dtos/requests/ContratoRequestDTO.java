package com.lorranpds.vitaflow.medical_registry.dtos.requests;

import com.lorranpds.vitaflow.medical_registry.domain.Cargo;

public record ContratoRequestDTO(
        String nomeFuncionario,
        Cargo cargo,
        String clausulaExtra // Opcional, para testarmos o isolamento
) {}
