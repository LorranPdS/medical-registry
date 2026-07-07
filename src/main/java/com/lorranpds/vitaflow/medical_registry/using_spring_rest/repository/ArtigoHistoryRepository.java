package com.lorranpds.vitaflow.medical_registry.using_spring_rest.repository;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.ArtigoMemento;
import org.springframework.stereotype.Repository;

import java.util.*;

/*
    3. CARETAKER - responsável por gerenciar o histórico

    Para manter o Service focado apenas na coordenação das ações, isolamos a responsabilidade
    de "guardar e buscar históricos" em um componente à parte.
    Aqui simulamos o armazenamento em memória RAM mapeado por ID, simulando o comportamento de tabelas de auditoria.
 */
@Repository
public class ArtigoHistoryRepository {

    // Cada ID de artigo ganha a sua própria pilha (Stack) independente de históricos
    // Mudamos a chave do mapa de Long para UUID. Segurança total por isolamento
    private final Map<UUID, Deque<ArtigoMemento>> tabelasDeHistorico = new HashMap<>();

    public void salvarNoHistorico(UUID artigoCodigo, ArtigoMemento snapshot) {
        tabelasDeHistorico.putIfAbsent(artigoCodigo, new ArrayDeque<>());
        tabelasDeHistorico.get(artigoCodigo).push(snapshot);
    }

    public Optional<ArtigoMemento> buscarUltimoHistorico(UUID artigoCodigo) {
        Deque<ArtigoMemento> pilha = tabelasDeHistorico.get(artigoCodigo);
        if (pilha != null && !pilha.isEmpty()) {
            return Optional.of(pilha.pop()); // Remove e entrega o último backup feito
        }
        return Optional.empty();
    }
}
