package com.lorranpds.vitaflow.medical_registry.using_spring_rest.dtos;

public record OrganogramaResponseDTO(
        String departamentoId,
        String nomeResponsavel,
        String cargoResponsavel,
        double custoTotalFolha,
        int totalSubordinados
){}
