package com.lorranpds.vitaflow.medical_registry.using_spring_rest.service;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.dto.ArtigoRequest;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.dto.ArtigoResponse;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.Artigo;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.ArtigoMemento;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.repository.ArtigoHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ArtigoService {

    private final ArtigoHistoryRepository historyRepository;

    // Simulação do nosso banco de dados relacional principal de artigos
    private final Map<UUID, Artigo> bancoPrincipalArtigos = new HashMap<>();

    public ArtigoService(ArtigoHistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
        // Populando dados iniciais na inicialização para fins de teste
        bancoPrincipalArtigos.put(UUID.fromString("6b31cbbe-db68-4d2c-b655-fcd123f676dd"), new Artigo("O Sol vai brilhar amanhã", "Previsão de tempo limpo."));
    }

    public ArtigoResponse atualizarArtigo(UUID id, ArtigoRequest request) {
        Artigo artigoExistente = bancoPrincipalArtigos.get(id);
        if (artigoExistente == null) {
            throw new RuntimeException("Artigo não localizado");
        }

        // 1. CARETAKER em ação: Pede um snapshot imutável do estado ATUAL do artigo e salva
        ArtigoMemento backupDoPassado = artigoExistente.criarSnapshot();
        historyRepository.salvarNoHistorico(id, backupDoPassado);

        // 2. Transforma as informações do DTO de Entrada para a Entidade Principal
        artigoExistente.setTitulo(request.titulo());
        artigoExistente.setTexto(request.texto());

        // 3. Persiste no banco de dados principal
        bancoPrincipalArtigos.put(id, artigoExistente);

        // 4. Mapeia para o DTO de Saída
        return new ArtigoResponse(id, artigoExistente.getTitulo(), artigoExistente.getTexto());
    }

    public ArtigoResponse desfazerUltimaAlteracao(UUID id) {
        Artigo artigoExistente = bancoPrincipalArtigos.get(id);
        if (artigoExistente == null) {
            throw new RuntimeException("Artigo não localizado");
        }

        // 1. Busca na cápsula do tempo se há históricos salvos para este artigo
        ArtigoMemento snapshotAnterior = historyRepository.buscarUltimoHistorico(id)
                .orElseThrow(() -> new RuntimeException("Nenhum histórico disponível para desfazer"));

        // 2. ORIGINATOR em ação: O artigo consome o memento e força a restauração interna
        artigoExistente.restaurarSnapshot(snapshotAnterior);

        // 3. Atualiza na base de dados principal o estado recuperado do passado
        bancoPrincipalArtigos.put(id, artigoExistente);

        return new ArtigoResponse(id, artigoExistente.getTitulo(), artigoExistente.getTexto());
    }
}