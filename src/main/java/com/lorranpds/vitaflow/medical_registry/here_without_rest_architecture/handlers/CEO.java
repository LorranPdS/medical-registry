package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.handlers;

import java.math.BigDecimal;

// 2. Handler Concreto
public class CEO extends Aprovador {

    @Override
    public void processarRequisicao(BigDecimal valor){
        System.out.println("CEO aprovou (e questionou) a compra de R$" + valor);
    }
}
