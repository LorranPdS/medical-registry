package com.lorranpds.vitaflow.medical_registry.classic_facade.propriofacade;

import com.lorranpds.vitaflow.medical_registry.classic_facade.subsistemascomplexos.ArCondicionado;
import com.lorranpds.vitaflow.medical_registry.classic_facade.subsistemascomplexos.Iluminacao;
import com.lorranpds.vitaflow.medical_registry.classic_facade.subsistemascomplexos.Televisao;

// 2. O Facade
public class HomeTheaterFacade {

    private final Iluminacao luzes;
    private final ArCondicionado ar;
    private final Televisao tv;

    public HomeTheaterFacade(){
        this.luzes = new Iluminacao();
        this.ar = new ArCondicionado();
        this.tv = new Televisao();
    }

    // Metodo simplificado para o cliente
    public void modoCinema(){
        System.out.println("\nPreparando o Modo Cinema...");
        luzes.abaixarLuzes();
        ar.ligar();
        tv.ligar();
    }

    public void encerrarCinema(){
        System.out.println("\nEncerrando o Modo Cinema...");
        tv.desligar();
        ar.desligar();
        luzes.acenderLuzes();
    }
}
