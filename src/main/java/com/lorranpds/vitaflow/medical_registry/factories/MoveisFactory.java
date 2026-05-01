package com.lorranpds.vitaflow.medical_registry.factories;

import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;

public interface MoveisFactory {
    Cadeira criarCadeira();
    Sofa criarSofa();
}
