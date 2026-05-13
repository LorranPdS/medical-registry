package com.lorranpds.vitaflow.medical_registry.singleton;

import org.junit.jupiter.api.Test;

class EnumSingletonTest {

    @Test
    void testandoExecucaoDoMetodoDoSingleton(){
        EnumSingleton.INSTANCE.exibirTema();
    }

    @Test
    void comprovandoQueAsInstanciasSaoUnicas(){
        EnumSingleton gerenciador1 = EnumSingleton.INSTANCE;
        System.out.println(gerenciador1);

        EnumSingleton gerenciador2 = EnumSingleton.INSTANCE;
        System.out.println(gerenciador2);

        System.out.println(gerenciador1 == gerenciador2);
        gerenciador1.exibirTema();
    }

    @Test
    void cenarioDeErroComThreadsSemSynchronizedNaoOcorreComEnumSingleton(){
        Runnable tarefa = () -> {
            EnumSingleton gerenciador = EnumSingleton.INSTANCE;
            System.out.println(Thread.currentThread().getName() + " pegou o objeto: " + gerenciador.hashCode());
        };

        // Disparamos as duas ao mesmo tempo
        new Thread(tarefa, "Thread-A").start();
        new Thread(tarefa, "Thread-B").start();
    }
}