package com.lorranpds.vitaflow.medical_registry.using_spring_rest.services;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.dtos.OrganogramaResponseDTO;

public interface OrganogramaService {
    OrganogramaResponseDTO consultarRelatorioPorDepartamento(String codigoDepartamento);
}
