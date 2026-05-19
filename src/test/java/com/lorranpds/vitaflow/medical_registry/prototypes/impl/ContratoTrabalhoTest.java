package com.lorranpds.vitaflow.medical_registry.prototypes.impl;

import com.lorranpds.vitaflow.medical_registry.enums.Cargo;
import org.junit.jupiter.api.Test;

class ContratoTrabalhoTest {

    @Test
    void garantindoIsolamentoAoImplementarPrototype(){
        // 1. Criação do Protótipo (Gera o delay de 2 segundos)
        System.out.println("Iniciando cache de contratos base...");
        ContratoTrabalho prototipoDevJava = new ContratoTrabalho(Cargo.DESENVOLVEDOR_JAVA);

        // 2. Criação do Primeiro Funcionário (Instantâneo)
        System.out.println("\nContratando Funcionario 1...");
        ContratoTrabalho contratoAna = prototipoDevJava.clonar();
        contratoAna.setNomeFuncionario("Ana");
        // Adicionamos uma cláusula exclusiva para a Ana
        contratoAna.getRegrasSindicato().adicionarClausulaEspecifica("Bônus de assinatura de R$ 5.000");

        // 3. Criação do Segundo Funcionário (Instantâneo)
        System.out.println("Contratando Funcionario 2...");
        ContratoTrabalho contratoCarlos = prototipoDevJava.clonar();
        contratoCarlos.setNomeFuncionario("Carlos");

        // 4. Verificação Final
        System.out.println("\nVerificando Isolamento dos Contratos:");
        contratoAna.imprimirResumo();

        // O contrato do Carlos NÃO DEVE ter o bônus da Ana
        contratoCarlos.imprimirResumo();
    }
}