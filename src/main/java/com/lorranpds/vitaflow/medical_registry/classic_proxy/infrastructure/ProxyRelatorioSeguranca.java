package com.lorranpds.vitaflow.medical_registry.classic_proxy.infrastructure;

import com.lorranpds.vitaflow.medical_registry.classic_proxy.model.Agente;
import com.lorranpds.vitaflow.medical_registry.classic_proxy.model.Cargo;
import com.lorranpds.vitaflow.medical_registry.classic_proxy.services.RelatorioInteligencia;
import com.lorranpds.vitaflow.medical_registry.classic_proxy.services.RelatorioUltraSecreto;

// 3 - Proxy (Controla o acesso ao Real Subject)
public class ProxyRelatorioSeguranca implements RelatorioInteligencia {

    private RelatorioUltraSecreto relatorioReal;

    @Override
    public String lerConteudo(Agente agente){
        // Lógica do Proxy: Verificação de acesso
        if (!Cargo.DIRETOR.equals(agente.cargo())) {
            throw new SecurityException("Acesso negado para o agente: " + agente.nome());
        }

        // Lazy initialization: só instancia o objeto real se a permissão foi concedida
        // e se for realmente necessário.
        if (relatorioReal == null) {
            this.relatorioReal = new RelatorioUltraSecreto();
        }

        System.out.println("LOG: Acesso concedido ao agente " + agente.nome());

        return relatorioReal.lerConteudo(agente);
    }
}
