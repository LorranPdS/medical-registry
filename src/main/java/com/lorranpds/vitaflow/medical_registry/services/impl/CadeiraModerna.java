package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CadeiraModerna implements Cadeira {

    @Override
    public void sentar() {
        log.info("### Sentando em uma Cadeira Moderna ###");
    }
}
