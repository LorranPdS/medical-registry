package com.lorranpds.vitaflow.medical_registry.factories.impl;

import com.lorranpds.vitaflow.medical_registry.factories.MoveisFactory;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;
import com.lorranpds.vitaflow.medical_registry.services.impl.moderno.CadeiraModerna;
import com.lorranpds.vitaflow.medical_registry.services.impl.moderno.SofaModerno;

public class ModernoMoveisFactory implements MoveisFactory {
    @Override
    public Cadeira criarCadeira() {
        return new CadeiraModerna();
    }

    @Override
    public Sofa criarSofa() {
        return new SofaModerno();
    }
}
