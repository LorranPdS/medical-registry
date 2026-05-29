package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dtos.command.FreteCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.response.FreteResponse;

import java.util.List;

public interface CalculadoraFreteServiceInterface {
    List<FreteResponse> calcular(FreteCommand command);
}
