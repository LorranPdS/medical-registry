package com.lorranpds.vitaflow.medical_registry.using_spring_rest.repositories;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.Colaborador;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.Gestor;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.MembroEquipe;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class OrganogramaRepositoryMock implements OrganogramaRepository{

    // Simula as tabelas do banco de dados organizadas por chave/código
    private final Map<String, MembroEquipe> bancoSimulado = new HashMap<>();

    public OrganogramaRepositoryMock(){
        popularBancoSimulado();
    }

    private void popularBancoSimulado(){
        // --- 1. Árvore da Engenharia/TI (DEP-ENG) ---
        Gestor techLead = new Gestor("Roberto Dias", "Tech Lead Backend", 16000.0);
        techLead.adicionarMembro(new Colaborador("Ana Silva", "Dev Java Senior", 12000.0));
        techLead.adicionarMembro(new Colaborador("Carlos Souza", "Dev Java Pleno", 7500.0));

        Gestor gerenteEngenharia = new Gestor("Fernanda Torres", "Gerente de Engenharia", 25000.0);
        gerenteEngenharia.adicionarMembro(techLead);
        gerenteEngenharia.adicionarMembro(new Colaborador("Beatriz Lima", "QA Lead", 8000.0));

        bancoSimulado.put("DEP-ENG", gerenteEngenharia);

        // --- 2. Árvore do Comercial/Vendas (DEP-VENDAS) ---
        Gestor gerenteVendas = new Gestor("Mariana Rios", "Gerente Comercial", 20000.0);
        gerenteVendas.adicionarMembro(new Colaborador("Lucas Mendes", "Executivo de Contas", 6000.0));
        gerenteVendas.adicionarMembro(new Colaborador("Julia Paes", "SDR", 4000.0));

        bancoSimulado.put("DEP-VENDAS", gerenteVendas);
    }

    @Override
    public Optional<MembroEquipe> buscarPorCodigoDepartamento(String codigoDepartamento){
        // Retorna o nó raiz da árvore cadastrado para o código solicitado
        return Optional.ofNullable(bancoSimulado.get(codigoDepartamento.toUpperCase()));
    }
}
