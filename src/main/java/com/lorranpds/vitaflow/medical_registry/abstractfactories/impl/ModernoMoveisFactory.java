package com.lorranpds.vitaflow.medical_registry.abstractfactories.impl;

import com.lorranpds.vitaflow.medical_registry.abstractfactories.MoveisFactory;
import com.lorranpds.vitaflow.medical_registry.enums.EstiloMoveis;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;
import com.lorranpds.vitaflow.medical_registry.services.impl.CadeiraModerna;
import com.lorranpds.vitaflow.medical_registry.services.impl.SofaModerno;
import org.springframework.stereotype.Component;

@Component
public class ModernoMoveisFactory implements MoveisFactory {

    @Override
    public EstiloMoveis getEstilo() {
        return EstiloMoveis.MODERNO;
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
