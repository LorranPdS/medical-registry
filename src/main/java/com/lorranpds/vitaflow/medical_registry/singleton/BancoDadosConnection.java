package com.lorranpds.vitaflow.medical_registry.singleton;

import com.lorranpds.vitaflow.medical_registry.connectionexample.ConnectionExample;
import com.lorranpds.vitaflow.medical_registry.connectionexample.DriverManagerExample;

// Forma 3: a intenção é aproveitar a imutabilidade do Enum
// Variação do Singleton: EnumSingleton
public enum BancoDadosConnection {
    INSTANCE;

    // 1. Atributo final: uma vez atribuído, nunca muda.
    private final ConnectionExample connection;
    private final String usuario = "admin"; // pelo que entendi, viria também por variáveis de ambiente

    BancoDadosConnection(){
        try{
            String url = "jdbc:postgresql://localhost:5432/vitaflow";

            // Tentativa de conexão
            ConnectionExample conn = DriverManagerExample.getConnection(url, usuario, "1234");

            // Validação: se o driver retornou null, algo está errado
            if (conn == null) {
                throw new RuntimeException("Driver retornou conexão nula.");
            }

            this.connection = conn;
        } catch (Exception e) {
            // 2. O GRITO: Se falhar aqui, a aplicação trava logo no boot.
            // Usamos ExceptionInInitializerError para indicar falha crítica em componente estático
            throw new ExceptionInInitializerError("Falha ao conectar no banco de dados. " + e.getMessage());
        }
    }

    public ConnectionExample getConnection(){
        System.out.printf("Conexão do usuário %s estabelecida com sucesso!%n", usuario);
        return this.connection;
    }
}
