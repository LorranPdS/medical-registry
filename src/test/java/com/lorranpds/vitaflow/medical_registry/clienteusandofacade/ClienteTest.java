package com.lorranpds.vitaflow.medical_registry.clienteusandofacade;

import com.lorranpds.vitaflow.medical_registry.classic_facade.propriofacade.HomeTheaterFacade;
import org.junit.jupiter.api.Test;

// 3. Cliente
public class ClienteTest {

    @Test
    void testandoCliente(){
        HomeTheaterFacade facade = new HomeTheaterFacade();

        // O cliente só conhece o Facade, ignorando a complexidade abaixo
        facade.modoCinema();
        facade.encerrarCinema();
    }
}
