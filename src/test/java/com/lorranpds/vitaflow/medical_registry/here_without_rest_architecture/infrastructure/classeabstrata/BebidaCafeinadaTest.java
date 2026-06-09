package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.classeabstrata;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.classesconcretas.Cafe;
import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.classesconcretas.Cha;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BebidaCafeinadaTest {

    @Test
    @DisplayName("Deve preparar o Café seguindo o esqueleto completo do algoritmo")
    void devePrepararCafeComSucesso(){
        // Arrange (Instancia a classe concreta)
        BebidaCafeinada cafe = new Cafe();

        // Act (Chama o Template Method)
        cafe.prepararReceita();

        // Assert (Verifica se as etapas foram executadas na ordem correta)
        List<String> passos = cafe.getPassosExecutados();

        assertEquals(4, passos.size(), "O processo de café deve ter exatamente 4 passos");
        assertEquals("Fervendo água", passos.get(0));
        assertEquals("Passando o café no filtro", passos.get(1)); // Passo específico da subclasse
        assertEquals("Colocando na xícara", passos.get(2));
        assertEquals("Adicionando açúcar e leite", passos.get(3)); // Passo específico da subclasse
    }

    @Test
    @DisplayName("Deve preparar o Chá pulando condimentos por conta do Hook customizado")
    void devePrepararChaIgnorandoCondimentosPeloHook(){
        // Arrange
        BebidaCafeinada cha = new Cha();

        // Act
        cha.prepararReceita();

        // Assert
        List<String> passos = cha.getPassosExecutados();

        // O chá deve ter apenas 3 passos, porque o gancho 'clienteQuerCondimentos' retornou false
        assertEquals(3, passos.size(), "O processo de chá deve ter apenas 3 passos");
        assertEquals("Fervendo água", passos.get(0));
        assertEquals("Mergulhando o sachê de chá", passos.get(1));
        assertEquals("Colocando na xícara", passos.get(2));

        // Verifica se o passo de condimentos realmente NÃO foi adicionado à lista
        assertFalse(passos.contains("Adicionando limão"), "O chá não deveria ter condimentos");
    }
}
