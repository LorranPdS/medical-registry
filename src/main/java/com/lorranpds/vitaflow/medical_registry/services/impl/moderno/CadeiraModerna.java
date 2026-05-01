package com.lorranpds.vitaflow.medical_registry.services.impl.moderno;

import com.lorranpds.vitaflow.medical_registry.services.Cadeira;

public class CadeiraModerna implements Cadeira {
    @Override
    public void sentar() {
        System.out.println("Sentando em uma cadeira moderna");
    }
}
