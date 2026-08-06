package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain;

// Nosso modelo interno limpo e imutável
public record Medico(
        String crm,
        String nome,
        boolean ativo
) {}
