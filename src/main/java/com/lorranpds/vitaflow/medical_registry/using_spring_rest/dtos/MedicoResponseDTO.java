package com.lorranpds.vitaflow.medical_registry.using_spring_rest.dtos;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.Medico;

import static com.lorranpds.vitaflow.medical_registry.using_spring_rest.dtos.StatusMedico.INATIVO;

// DTO retornado para o cliente da NOSSA API REST
public record MedicoResponseDTO(
        String crm,
        String nome,
        StatusMedico status) {

    public static MedicoResponseDTO fromDomain(Medico medico) {
        return new MedicoResponseDTO(
                medico.crm(),
                medico.nome(),
                medico.ativo() ? StatusMedico.ATIVO : INATIVO
        );
    }
}
