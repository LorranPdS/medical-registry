package com.lorranpds.vitaflow.medical_registry.using_spring_rest.model;

/*
    1. MEMENTO
        Geralmente seria uma Entity no banco atrelada a uma tabela de histórico

        Como record, ela se torna 100% imutável
 */
public record ArtigoMemento(String titulo, String texto) {
}
