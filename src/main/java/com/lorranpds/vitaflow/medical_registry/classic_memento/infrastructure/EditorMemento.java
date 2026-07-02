package com.lorranpds.vitaflow.medical_registry.classic_memento.infrastructure;

/*
    1. Memento: Guarda o estado (Deve ser imutável)

    Essa classe pode ser feita também em uma record se estiver com Java 16+
 */
public class EditorMemento {

    private final String conteudo;

    public EditorMemento(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }
}
