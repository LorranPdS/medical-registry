package com.lorranpds.vitaflow.medical_registry.using_spring_rest.repository;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.ArtigoMemento;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ArtigoHistoryRepository {

    // Cada ID de artigo ganha a sua própria pilha (Stack) independente de históricos
    private final Map<Long, Deque<ArtigoMemento>> tabelasDeHistorico = new HashMap<>();

    public void salvarNoHistorico(Long artigoId, ArtigoMemento snapshot) {
        tabelasDeHistorico.putIfAbsent(artigoId, new ArrayDeque<>());
        tabelasDeHistorico.get(artigoId).push(snapshot);
    }

    public Optional<ArtigoMemento> buscarUltimoHistorico(Long artigoId) {
        Deque<ArtigoMemento> pilha = tabelasDeHistorico.get(artigoId);
        if (pilha != null && !pilha.isEmpty()) {
            return Optional.of(pilha.pop()); // Remove e entrega o último backup feito
        }
        return Optional.empty();
    }
}
