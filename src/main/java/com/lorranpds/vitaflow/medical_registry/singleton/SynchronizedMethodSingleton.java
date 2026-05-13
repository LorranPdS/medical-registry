package com.lorranpds.vitaflow.medical_registry.singleton;

// FORMA 1 DO SINGLETON LIDAR COM THREADS: synchronized methods
public class SynchronizedMethodSingleton {

    private static SynchronizedMethodSingleton instance;

    private String configuracao;

    private SynchronizedMethodSingleton(){
        this.configuracao = "PostgreSQL";
    }

    // Aqui está o synchronized method
    public static synchronized SynchronizedMethodSingleton getInstance(){
        // não é comum pra mercado usar Optional.ofNullable().orElseGet() na validação abaixo
        if(instance == null){
            instance = new SynchronizedMethodSingleton();
        }
        return instance;
    }

    public void showConfiguration(){
        System.out.println("A configuração atual é " + configuracao);
    }
}
