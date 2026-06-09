package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.classesconcretas;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.classeabstrata.BebidaCafeinada;

// 3. Subclasse Concreta 2
public class Cha extends BebidaCafeinada {

    @Override
    protected void preparar() {
        System.out.println("Mergulhando o sachê de chá...");
        getPassosExecutados().add("Mergulhando o sachê de chá");
    }

    @Override
    protected void adicionarCondimentos() {
        System.out.println("Adicionando limão...");
        getPassosExecutados().add("Adicionando limão");
    }

    // Sobrescrevendo o gancho (Hook) para NÃO colocar condimentos
    @Override
    protected boolean clienteQuerCondimentos(){
        return false; // Este chá será servido puro
    }
}
