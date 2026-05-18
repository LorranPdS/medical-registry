package com.lorranpds.vitaflow.medical_registry.singleton;

import com.lorranpds.vitaflow.medical_registry.connectionexample.ConnectionExample;
import org.junit.jupiter.api.Test;

class EnumDataBaseConnectionTest {

    @Test
    void testandoExecucaoDoMetodoDoSingleton(){
        EnumDataBaseConnection.INSTANCE.getConnection();
    }

    @Test
    void comprovandoQueAsInstanciasSaoUnicas(){
        EnumDataBaseConnection gerenciador1 = EnumDataBaseConnection.INSTANCE;
        System.out.println(gerenciador1);

        EnumDataBaseConnection gerenciador2 = EnumDataBaseConnection.INSTANCE;
        System.out.println(gerenciador2);

        System.out.println(gerenciador1 == gerenciador2);
        gerenciador1.getConnection();
    }

    @Test
    void cenarioDeErroComThreadsSemSynchronizedNaoOcorreComEnumSingleton(){
        Runnable tarefa = () -> {
            EnumDataBaseConnection gerenciador = EnumDataBaseConnection.INSTANCE;
            System.out.println(Thread.currentThread().getName() + " pegou o objeto: " + gerenciador.hashCode());
        };

        // Disparamos as duas ao mesmo tempo
        new Thread(tarefa, "Thread-A").start();
        new Thread(tarefa, "Thread-B").start();
    }

    @Test
    void comprovandoQueOEnumMantemAInstanciaUnica() {
        // Pegando o gerenciador de dois lugares diferentes
        EnumDataBaseConnection gerenciador1 = EnumDataBaseConnection.INSTANCE;
        EnumDataBaseConnection gerenciador2 = EnumDataBaseConnection.INSTANCE;

        // Vai dar TRUE (provando o Singleton)
        System.out.println("Mesmo Gerenciador? " + (gerenciador1 == gerenciador2));

        // Pegando as conexões de dentro deles
        ConnectionExample c1 = gerenciador1.getConnection();
        ConnectionExample c2 = gerenciador2.getConnection();

        // Vai dar TRUE e mostrar HashCodes iguais do recurso interno!
        System.out.println("Mesma Conexão? " + (c1 == c2));
    }
}
