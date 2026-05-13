package com.lorranpds.vitaflow.medical_registry.singleton;

// Aqui temos um exemplo mais próximo da realidade
public enum TelemedicinaConfigExample {
    INSTANCIA;

    private final String urlBase = "https://api.telemedicina.com/v1";
    private String apiKey;

    // Construtor de Enum é privado por padrão
    TelemedicinaConfigExample() {
        // Imagine que aqui ele lê de um arquivo .env ou do banco
        this.apiKey = "CHAVE_RESTRITA_123";
    }

    public void conectar() {
        System.out.println("Conectando em " + urlBase + " com a chave " + apiKey);
    }
}
