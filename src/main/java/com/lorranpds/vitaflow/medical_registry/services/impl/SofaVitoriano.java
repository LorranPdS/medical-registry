package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.services.Sofa;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SofaVitoriano implements Sofa {
    @Override
    public void deitar() {
        log.info("### Deitando em um Sofá Vitoriano ###");
    }
}
