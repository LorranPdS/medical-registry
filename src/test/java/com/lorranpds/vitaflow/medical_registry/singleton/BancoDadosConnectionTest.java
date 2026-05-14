package com.lorranpds.vitaflow.medical_registry.singleton;

import org.junit.jupiter.api.Test;

class BancoDadosConnectionTest {

    @Test
    void testandoExecucaoDoMetodoDoSingleton(){
        BancoDadosConnection.INSTANCE.getConnection();
    }

    @Test
    void comprovandoQueAsInstanciasSaoUnicas(){
        BancoDadosConnection gerenciador1 = BancoDadosConnection.INSTANCE;
        System.out.println(gerenciador1);

        BancoDadosConnection gerenciador2 = BancoDadosConnection.INSTANCE;
        System.out.println(gerenciador2);

        System.out.println(gerenciador1 == gerenciador2);
        gerenciador1.getConnection();
    }

    @Test
    void cenarioDeErroComThreadsSemSynchronizedNaoOcorreComEnumSingleton(){
        Runnable tarefa = () -> {
            BancoDadosConnection gerenciador = BancoDadosConnection.INSTANCE;
            System.out.println(Thread.currentThread().getName() + " pegou o objeto: " + gerenciador.hashCode());
        };

        // Disparamos as duas ao mesmo tempo
        new Thread(tarefa, "Thread-A").start();
        new Thread(tarefa, "Thread-B").start();
    }
}