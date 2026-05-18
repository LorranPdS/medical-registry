package com.lorranpds.vitaflow.medical_registry.singleton;

import com.lorranpds.vitaflow.medical_registry.connectionexample.ConnectionExample;
import com.lorranpds.vitaflow.medical_registry.connectionexample.DriverManagerExample;

// 4 - Variação do Singleton recomendada por Joshua Bloch: Enum Singleton
/*
    Esta é a implementação mais segura e robusta no Java moderno.
    Ela elimina completamente a necessidade de checagens manuais de nulidade,
    métodos estáticos getInstance() e travas de concorrência.
    A própria JVM garante que a INSTANCE é única, thread-safe e imutável.
 */
public enum EnumDataBaseConnection {

    // O ponto de acesso global único que substitui a variável "instance"
    INSTANCE;

    // Como o enum garante que o construtor roda só uma vez,
    // podemos usar o 'final' de verdade aqui para proteger nosso recurso!
    private final ConnectionExample connection;

    // Construtores de Enum são implicitamente privados no Java
    EnumDataBaseConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/vitaflow";
            // Simulando a inicialização demorada como no seu modelo clássico
            Thread.sleep(100);

            // Atribuição direta e segura do recurso
            ConnectionExample conn = DriverManagerExample.getConnection(url, "admin", "123");

            if (conn == null) {
                throw new RuntimeException("O Driver retornou uma conexão nula.");
            }

            this.connection = conn;

        } catch (Exception e) {
            // Lançando o erro fatal logo na inicialização da classe caso o banco falhe
            throw new ExceptionInInitializerError("ERRO CRÍTICO: Falha ao inicializar o banco VitaFlow. " + e.getMessage());
        }
    }

    public ConnectionExample getConnection() {
        System.out.println("Pegando a conexão do Enum Singleton");
        return this.connection;
    }
}
