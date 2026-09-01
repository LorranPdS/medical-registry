package com.lorranpds.vitaflow.medical_registry.classic_proxy.services;

import com.lorranpds.vitaflow.medical_registry.classic_proxy.model.Agente;

// 2 - Real Subject (O objeto que faz o trabalho real e sensível)
public class RelatorioUltraSecreto implements RelatorioInteligencia{

    @Override
    public String lerConteudo(Agente agente){
        // Simula uma busca complexa no banco de dados
        return "CONTEÚDO SECRETO: A anomalia foi contida no setor 7.";
    }
}
