package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.Medico;

// 2. Target - A interface do nosso sistema. O Service só conhece esta interface
public interface ConselhoMedicoGateway {
    Medico buscarPorCrm(String crm);
}
