package com.lorranpds.vitaflow.medical_registry.classic_proxy.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
    1) nosso record está representando o usuário logado.
    2) os parâmetros do objeto nunca nascerão sem dados já que estou colocando @NotBlank e @NotNull neles,
        logo, qualquer validação posterior se é nula seria "redundância defensiva desnecessária"
 */
public record Agente(@NotBlank String nome, @NotNull Cargo cargo){}
