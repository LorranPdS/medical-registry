package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.handlers;

import java.math.BigDecimal;

// 1. O Handler Abstrato
public abstract class Aprovador {

    protected Aprovador proximoAprovador;

    public void setProximo(Aprovador proximoAprovador){
        this.proximoAprovador = proximoAprovador;
    }

    public abstract void processarRequisicao(BigDecimal valor);
}
