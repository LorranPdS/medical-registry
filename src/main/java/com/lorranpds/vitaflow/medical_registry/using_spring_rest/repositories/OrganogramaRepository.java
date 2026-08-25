package com.lorranpds.vitaflow.medical_registry.using_spring_rest.repositories;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.MembroEquipe;

import java.util.Optional;

public interface OrganogramaRepository{
    Optional<MembroEquipe> buscarPorCodigoDepartamento(String codigoDepartamento);
}
