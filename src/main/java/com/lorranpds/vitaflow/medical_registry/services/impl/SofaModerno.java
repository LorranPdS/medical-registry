package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.services.Sofa;

public class SofaModerno implements Sofa {

    @Override
    public void deitar() {
        System.out.println("Deitando em um Sofá Moderno");
    }
}
