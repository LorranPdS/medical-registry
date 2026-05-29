package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dtos.command.FreteCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.response.FreteResponse;
import com.lorranpds.vitaflow.medical_registry.strategies.interfaces.FreteStrategy;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CalculadoraFreteService implements CalculadoraFreteServiceInterface {

    // O mapa que o Spring monta no construtor (Key: TipoFrete, Value: Classe Concreta)
    private final Map<TipoFrete, FreteStrategy> freteStrategyMap;

    public CalculadoraFreteService(List<FreteStrategy> strategies){
        this.freteStrategyMap = strategies.stream().collect(Collectors.toUnmodifiableMap(FreteStrategy::getTipoFrete, Function.identity()));
    }

    @Override
    public List<FreteResponse> calcular(FreteCommand command) {
        // 1. Defesa/Validação de negócio com o utilitário do Spring
        if (CollectionUtils.isEmpty(command.tiposFrete())) {
            throw new IllegalArgumentException("Por favor, selecione ao menos uma modalidade de frete.");
        }

        // 2. Direciona de forma limpa e expressiva para o processamento em lote
        return executarCalculoEmLote(command);
    }

    // Passa o rolo compressor (Stream) por cima de todos os Enums solicitados
    private List<FreteResponse> executarCalculoEmLote(FreteCommand command) {
        return command.tiposFrete().stream()
                .map(tipo -> calcularIndividual(tipo, command.pesoEmKg(), command.distanciaEmKm()))
                .collect(Collectors.toList());
    }

    private FreteResponse calcularIndividual(TipoFrete tipo, BigDecimal peso, BigDecimal distancia) {
        // Busca a estratégia no catálogo
        FreteStrategy estrategia = freteStrategyMap.get(tipo);

        // Fail-Fast: Proteção caso o mapa não encontre a classe cadastrada
        if (estrategia == null) {
            throw new IllegalArgumentException("Modalidade de frete não suportada: " + tipo);
        }

        // Executa o cálculo cego da estratégia ativa
        BigDecimal valorCalculado = estrategia.calcular(peso, distancia);

        // O GRANDE DETALHE: A própria classe concreta se identifica através da Interface!
        return new FreteResponse(estrategia.getTipoFrete(), valorCalculado);
    }
}
