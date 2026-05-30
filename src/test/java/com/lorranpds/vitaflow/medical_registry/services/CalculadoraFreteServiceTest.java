package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dtos.command.FreteCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.response.FreteResponse;
import com.lorranpds.vitaflow.medical_registry.strategies.FretePAC;
import com.lorranpds.vitaflow.medical_registry.strategies.FreteRetiradaNaLoja;
import com.lorranpds.vitaflow.medical_registry.strategies.FreteSedex;
import com.lorranpds.vitaflow.medical_registry.strategies.FreteTransportadoraX;
import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CalculadoraFreteServiceTest {

    private CalculadoraFreteService service;

    @BeforeEach
    void setUp() {
        // 1. Criamos uma lista com as estratégias reais do seu sistema
        List<FreteStrategy> strategies = List.of(
                new FretePAC(),
                new FreteSedex(),
                new FreteTransportadoraX(),
                new FreteRetiradaNaLoja()
        );

        // 2. Instanciamos o Service manualmente passando a lista para o construtor
        // Isso simula exatamente o que o Spring faz ao subir o servidor!
        this.service = new CalculadoraFreteService(strategies);
    }

    @Test
    void testingCalculoFrete() {
        FreteCommand freteCommand = getFreteCommand();

        // Agora o Service foi inicializado com sucesso e não dará erro de NullPointer
        List<FreteResponse> response = service.calcular(freteCommand);

        // Em vez de usar apenas o System.out.println, use o Assertions do JUnit para garantir o teste!
        assertNotNull(response);
        assertEquals(4, response.size());

        // 2. Transforma a lista em um mapa para facilitar a busca no assert
        Map<TipoFrete, BigDecimal> valoresPorTipo = response.stream()
                .collect(Collectors.toMap(FreteResponse::tipoFrete, FreteResponse::valor));

        // 3. Valida cada valor individual com precisão cirúrgica usando o compareTo do BigDecimal
        // Lembra que para BigDecimal, a boa prática é usar o compareTo() == 0 ou usar string no assertEquals
        assertEquals(0, BigDecimal.valueOf(34.00).compareTo(valoresPorTipo.get(TipoFrete.SEDEX)));
        assertEquals(0, BigDecimal.valueOf(13.50).compareTo(valoresPorTipo.get(TipoFrete.PAC)));
        assertEquals(0, BigDecimal.valueOf(20.00).compareTo(valoresPorTipo.get(TipoFrete.TRANSPORTADORA_X)));
        assertEquals(0, BigDecimal.ZERO.compareTo(valoresPorTipo.get(TipoFrete.RETIRADA_LOJA)));
    }

    private FreteCommand getFreteCommand() {
        // Em vez de .allOf(), eu poderia ter escolhido apenas esses 2 e lá no setUp() setar apenas esses dois também
//        EnumSet<TipoFrete> tiposFrete = EnumSet.of(TipoFrete.PAC, TipoFrete.SEDEX);

        EnumSet<TipoFrete> tiposFrete = EnumSet.allOf(TipoFrete.class);
        BigDecimal pesoEmKg = BigDecimal.valueOf(5.0);
        BigDecimal distanciaEmKm = BigDecimal.valueOf(10.0);

        return new FreteCommand(tiposFrete, pesoEmKg, distanciaEmKm);
    }
}