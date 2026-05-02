package com.lorranpds.vitaflow.medical_registry.factories.impl;

import com.lorranpds.vitaflow.medical_registry.enums.EstiloMovelEnum;
import com.lorranpds.vitaflow.medical_registry.factories.MoveisFactory;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;
import com.lorranpds.vitaflow.medical_registry.services.impl.CadeiraModerna;
import com.lorranpds.vitaflow.medical_registry.services.impl.SofaModerno;
import org.springframework.stereotype.Component;

@Component
public class ModernoMoveisFactory implements MoveisFactory {

    @Override
    public EstiloMovelEnum getEstilo() {
        return EstiloMovelEnum.MODERNO;
    }

    @Override
    public Cadeira criarCadeira() {
        return new CadeiraModerna();
    }

    @Override
    public Sofa criarSofa() {
        return new SofaModerno();
    }
}
