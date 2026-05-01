package com.lorranpds.vitaflow.medical_registry.services.impl.vitoriano;

import com.lorranpds.vitaflow.medical_registry.services.Cadeira;

// Grupo do Estilo Vitoriano - Produto Concreto
public class CadeiraVitoriana implements Cadeira {

    @Override
    public void sentar() {
        System.out.println("Sentando em uma cadeira vitoriana");
    }
}
