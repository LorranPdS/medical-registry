package com.lorranpds.vitaflow.medical_registry.singleton;

// Forma 3: a intenção é aproveitar a imutabilidade do Enum
public enum EnumSingleton {
    INSTANCE;

    private String tema = "Escuro";

    public void exibirTema() {
        System.out.println("Tema: " + tema);
    }
}
