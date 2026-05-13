package com.lorranpds.vitaflow.medical_registry.singleton;

import org.junit.jupiter.api.Test;
/*
    PONTO NEGATIVO DO SYNCHRONIZED METHOD: Performance.
        Toda vez que alguem pedir a instancia, o Java precisara travar o metodo,
        mesmo que a instância já tenha sido criada há muito tempo.
 */
class SynchronizedMethodSingletonTest {

    @Test
    void comprovandoQueAsInstanciasSaoUnicas(){
        SynchronizedMethodSingleton gerenciador1 = SynchronizedMethodSingleton.getInstance();
        System.out.println(gerenciador1);

        SynchronizedMethodSingleton gerenciador2 = SynchronizedMethodSingleton.getInstance();
        System.out.println(gerenciador2);

        System.out.println(gerenciador1 == gerenciador2);
        gerenciador1.showConfiguration();
    }

    @Test
    void cenarioDeErroComThreadsAndSynchronizedNaoOcorre(){
        Runnable tarefa = () -> {
            SynchronizedMethodSingleton gerenciador = SynchronizedMethodSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " pegou o objeto: " + gerenciador.hashCode());
        };

        // Disparamos as duas ao mesmo tempo
        new Thread(tarefa, "Thread-A").start();
        new Thread(tarefa, "Thread-B").start();
    }
}