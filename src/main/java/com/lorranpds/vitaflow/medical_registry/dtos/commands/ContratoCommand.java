package com.lorranpds.vitaflow.medical_registry.dtos.commands;

import com.lorranpds.vitaflow.medical_registry.domain.Cargo;

public record ContratoCommand(
        String nomeFuncionario,
        Cargo cargo,
        String clausulaExtra) {}
