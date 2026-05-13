package com.lorranpds.vitaflow.medical_registry.singleton;

import org.junit.jupiter.api.Test;

class TelemedicinaConfigExampleTest {

    @Test
    void testandoExecucaoDoMetodoDoSingleton(){
        TelemedicinaConfigExample.INSTANCIA.conectar();
    }

    @Test
    void comprovandoQueAsInstanciasSaoUnicas(){
        TelemedicinaConfigExample gerenciador1 = TelemedicinaConfigExample.INSTANCIA;
        System.out.println(gerenciador1);

        TelemedicinaConfigExample gerenciador2 = TelemedicinaConfigExample.INSTANCIA;
        System.out.println(gerenciador2);

        System.out.println(gerenciador1 == gerenciador2);
        gerenciador1.conectar();
    }

    @Test
    void cenarioDeErroComThreadsSemSynchronizedNaoOcorreComEnumSingleton(){
        Runnable tarefa = () -> {
            TelemedicinaConfigExample gerenciador = TelemedicinaConfigExample.INSTANCIA;
            System.out.println(Thread.currentThread().getName() + " pegou o objeto: " + gerenciador.hashCode());
        };

        // Disparamos as duas ao mesmo tempo
        new Thread(tarefa, "Thread-A").start();
        new Thread(tarefa, "Thread-B").start();
    }

}