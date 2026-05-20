package com.lorranpds.vitaflow.medical_registry.dtos.responses;

import com.lorranpds.vitaflow.medical_registry.domain.Cargo;
import com.lorranpds.vitaflow.medical_registry.domain.RegrasSindicato;

public record ContratoTrabalhoResponseDTO(Cargo cargo, RegrasSindicato regrasSindicato, String nomeFuncionario) {
}
