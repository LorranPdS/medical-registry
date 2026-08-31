package com.lorranpds.vitaflow.medical_registry.using_spring_rest.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

/*
    No contexto do negócio (prática de TI): Serviço de Gestão de Acessos Corporativos (ou Serviço de Identidades
        e Permissões).

    Na prática, o mercado mantém o termo em inglês "Active Directory" ou usa "Serviço de Acessos/Autenticação",
        pois o AD da Microsoft é o sistema que gerencia os usuários, logins e permissões da empresa).
 */

// 1 - Subsistemas complexos (Domain Services)
@Service
public class ActiveDirectoryService{ // A tradução literal seria "Serviço de Diretório Ativo
    public void concederAcessosIniciais(UUID idFuncionario){
        // Esse corpo simula algum tipo de lógica complexa com várias ações
        System.out.println("Permissões iniciais concedidas ao usuário " + idFuncionario);
    }
}
