package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.factories.MoveisFactory;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;

public class Loja {

    private Cadeira cadeira;
    private Sofa sofa;

    public Loja(MoveisFactory moveisFactory){
        this.cadeira = moveisFactory.criarCadeira();
        this.sofa = moveisFactory.criarSofa();
    }

    public void exibirConjunto(){
        cadeira.sentar();
        sofa.deitar();
    }
}
