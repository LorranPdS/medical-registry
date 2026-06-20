package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.handlers;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

// 2. Handler Concreto
@Slf4j
public class CEO extends Aprovador {

    @Override
    public void processarRequisicao(BigDecimal valor){
        log.info("{} aprovou (e questionou) a compra de R$ {}", this.getClass().getSimpleName(), valor);
    }
}
