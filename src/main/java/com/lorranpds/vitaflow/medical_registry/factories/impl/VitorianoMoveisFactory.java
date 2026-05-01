package com.lorranpds.vitaflow.medical_registry.factories.impl;

import com.lorranpds.vitaflow.medical_registry.factories.MoveisFactory;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;
import com.lorranpds.vitaflow.medical_registry.services.impl.vitoriano.CadeiraVitoriana;
import com.lorranpds.vitaflow.medical_registry.services.impl.vitoriano.SofaVitoriano;

public class VitorianoMoveisFactory implements MoveisFactory {
    @Override
    public Cadeira criarCadeira() {
        return new CadeiraVitoriana();
    }

    @Override
    public Sofa criarSofa() {
        return new SofaVitoriano();
    }
}
