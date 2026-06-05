package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.classesconcretas;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.classeabstrata.BebidaCafeinada;

// 2. Subclasse Concreta 1
public class Cafe extends BebidaCafeinada {

    @Override
    protected void preparar() {
        System.out.println("Passando o café no filtro...");
        getPassosExecutados().add("Passando o café no filtro");
    }

    @Override
    protected void adicionarCondimentos() {
        System.out.println("Adicionando açúcar e leite...");
        getPassosExecutados().add("Adicionando açúcar e leite");
    }
}
