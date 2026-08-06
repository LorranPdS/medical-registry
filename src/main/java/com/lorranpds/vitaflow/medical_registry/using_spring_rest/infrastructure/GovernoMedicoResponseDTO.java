package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

/*
    3. Adaptee (O contrato da API externa - DTO do Governo) - esse é o DTO que reflete o
        JSON feio ou diferente que vem da API do Governo
 */
public record GovernoMedicoResponseDTO(
        String idConselho,
        String nomeCompleto,
        String situacaoRegularizacao
){}
