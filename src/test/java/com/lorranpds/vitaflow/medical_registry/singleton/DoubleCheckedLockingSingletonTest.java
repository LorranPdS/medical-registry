package com.lorranpds.vitaflow.medical_registry.singleton;

import com.lorranpds.vitaflow.medical_registry.connectionexample.ConnectionExample;
import org.junit.jupiter.api.Test;

class DoubleCheckedLockingSingletonTest {

    @Test
    void comprovandoQueAsInstanciasSaoUnicas(){
        DoubleCheckedLockingSingleton gerenciador1 = DoubleCheckedLockingSingleton.getInstance();
        System.out.println(gerenciador1);

        DoubleCheckedLockingSingleton gerenciador2 = DoubleCheckedLockingSingleton.getInstance();
        System.out.println(gerenciador2);

        System.out.println(gerenciador1 == gerenciador2);
        ConnectionExample connection = gerenciador1.getConnection();
        System.out.println(connection);
    }

    @Test
    void cenarioDeErroComThreadsComVolatileAndSynchronizedNaoOcorrem(){
        Runnable tarefa = () -> {
            DoubleCheckedLockingSingleton gerenciador = DoubleCheckedLockingSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + " pegou o objeto: " + gerenciador.hashCode());
        };

        // Disparamos as duas ao mesmo tempo
        new Thread(tarefa, "Thread-A").start();
        new Thread(tarefa, "Thread-B").start();
    }
}
