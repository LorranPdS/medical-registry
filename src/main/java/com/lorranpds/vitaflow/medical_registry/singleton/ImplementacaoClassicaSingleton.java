package com.lorranpds.vitaflow.medical_registry.singleton;

import com.lorranpds.vitaflow.medical_registry.connectionexample.ConnectionExample;
import com.lorranpds.vitaflow.medical_registry.connectionexample.DriverManagerExample;

// 1 - Implementação clássica descrita no GoF: Lazy Initialization
/*
    Esta é a forma mais simples. Ela funciona bem em ambientes de thread única,
    mas como vimos, pode "quebrar" se várias threads chamarem o metodo ao mesmo
    tempo no início.
 */
public class ImplementacaoClassicaSingleton {

    private static ImplementacaoClassicaSingleton instance;
    private final ConnectionExample connection;

    private ImplementacaoClassicaSingleton(){
        try {
            String url = "jdbc:postgresql://localhost:5432/vitaflow";
            // Simulando uma inicialização demorada
            Thread.sleep(100);
            // Simulação da conexão - virão das variáveis de ambiente, por isso não tem parâmetro no construtor pra preencher
            this.connection = DriverManagerExample.getConnection(url, "admin", "123");
        }catch (InterruptedException | ExceptionInInitializerError e) {
            throw new ExceptionInInitializerError("Falha ao conectar no banco de dados. " + e.getMessage());
        }
    }

    public static ImplementacaoClassicaSingleton getInstance(){
        if(instance == null){
            instance = new ImplementacaoClassicaSingleton();
        }
        return instance;
    }

    public ConnectionExample getConnection(){
        System.out.println("Pegando a conexão");
        return this.connection;
    }
}
