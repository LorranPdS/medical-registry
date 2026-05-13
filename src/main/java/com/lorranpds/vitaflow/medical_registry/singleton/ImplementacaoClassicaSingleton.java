package com.lorranpds.vitaflow.medical_registry.singleton;

// 1 - Implementação clássica descrita no GoF: Lazy Initialization
public class ImplementacaoClassicaSingleton {

    private static ImplementacaoClassicaSingleton instancia;
    private String tema;

    private ImplementacaoClassicaSingleton(){
        try {
            // Simulando uma inicialização demorada (não vai existir esse bloco try/catch na realidade nem essa Thread)
            Thread.sleep(100);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.tema = "Escuro";
        System.out.println("Instância criada por: " + Thread.currentThread().getName());
    }

    public static ImplementacaoClassicaSingleton getInstance(){
        if(instancia == null){
            instancia = new ImplementacaoClassicaSingleton();
        }
        return instancia;
    }

    public void exibirTema(){
        System.out.println("O tema atual é " + tema);
    }
}
