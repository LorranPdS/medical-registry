package com.lorranpds.vitaflow.medical_registry.factories.impl;

import com.lorranpds.vitaflow.medical_registry.enums.EstiloMovelEnum;
import com.lorranpds.vitaflow.medical_registry.factories.MoveisFactory;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;
import com.lorranpds.vitaflow.medical_registry.services.impl.CadeiraVitoriana;
import com.lorranpds.vitaflow.medical_registry.services.impl.SofaVitoriano;
import org.springframework.stereotype.Component;

@Component
public class VitorianoMoveisFactory implements MoveisFactory {

    @Override
    public EstiloMovelEnum getEstilo() {
        return EstiloMovelEnum.VITORIANO;
    }

    @Override
    public Cadeira criarCadeira() {
        return new CadeiraVitoriana();
    }

    @Override
    public Sofa criarSofa() {
        return new SofaVitoriano();
    }
}
