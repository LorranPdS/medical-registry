package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain;

// 1. Composite - interface abstrata em comum
public interface MembroEquipe {

    // Não considerei os métodos como getters para compilar com a record sem acréscimos
    String nome();
    String cargo();
    double salario();
    int quantidadeSubordinados(); // Conta a equipe recursivamente
}
