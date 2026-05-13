package com.lorranpds.vitaflow.medical_registry.singleton;

import org.junit.jupiter.api.Test;

class ImplementacaoClassicaSingletonTest {

    @Test
    void comprovandoQueAsInstanciasSaoUnicas(){
        ImplementacaoClassicaSingleton gerenciador1 = ImplementacaoClassicaSingleton.getInstance();
        System.out.println(gerenciador1);

        ImplementacaoClassicaSingleton gerenciador2 = ImplementacaoClassicaSingleton.getInstance();
        System.out.println(gerenciador2);

        System.out.println(gerenciador1 == gerenciador2);
        gerenciador1.exibirTema();
    }

    @Test
    void cenarioDeErroComThreadsSemSynchronized(){
        // Observação: só consegui simular isso uma vez e foi no Debug. Não é tão simples simular mesmo
        Runnable tarefa = () -> {
            ImplementacaoClassicaSingleton gerenciador = ImplementacaoClassicaSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " pegou o objeto: " + gerenciador.hashCode());
        };

        // Disparamos as duas ao mesmo tempo
        new Thread(tarefa, "Thread-A").start();
        new Thread(tarefa, "Thread-B").start();
    }
}