package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dtos.commands.ContratoCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.responses.ContratoTrabalhoResponseDTO;

public interface ContratoService {

    ContratoTrabalhoResponseDTO gerarNovoContrato(ContratoCommand command);
}
