package com.lorranpds.vitaflow.medical_registry.singleton;

import com.lorranpds.vitaflow.medical_registry.connectionexample.ConnectionExample;
import com.lorranpds.vitaflow.medical_registry.connectionexample.DriverManagerExample;

// FORMA 1 DO SINGLETON LIDAR COM THREADS: synchronized methods - segura mas é lenta
/*
    Aqui resolvemos o problema das threads colocando um "guarda" na porta do metodo.
    A desvantagem é que, mesmo depois que a instância já foi criada, toda thread que
    quiser a conexão terá que esperar na fila da sincronização, o que gera gargalo.
 */
public class SynchronizedMethodSingleton {

    private static SynchronizedMethodSingleton instance;
    private ConnectionExample connection;

    private SynchronizedMethodSingleton(){
        try {
            String url = "jdbc:postgresql://localhost:5432/vitaflow";
            this.connection = DriverManagerExample.getConnection(url, "admin", "123");
        }catch (ExceptionInInitializerError e){
            throw new ExceptionInInitializerError("Falha ao conectar no banco de dados. " + e.getMessage());
        }
    }

    // Aqui está o synchronized method - O "synchronized" garante que apenas uma thread entre por vez
    public static synchronized SynchronizedMethodSingleton getInstance(){
        // não é comum pra mercado usar Optional.ofNullable().orElseGet() na validação abaixo
        if(instance == null){
            instance = new SynchronizedMethodSingleton();
        }
        return instance;
    }

    public ConnectionExample getConnection(){
        System.out.println("Pegando a conexão");
        return this.connection;
    }
}
