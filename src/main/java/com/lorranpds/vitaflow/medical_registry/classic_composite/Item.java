package com.lorranpds.vitaflow.medical_registry.classic_composite;

// 1. Component - Interface comum
public interface Item {

    /*
        Dica de Java Moderno: nomear os métodos da interface como nome() e preco()
        em vez de getNome() e getPreco() faz com que o record cumpra o contrato da
        interface automaticamente sem você precisar escrever nada
     */
    String nome();
    double preco();
}
