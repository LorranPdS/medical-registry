package com.lorranpds.vitaflow.medical_registry.using_spring_rest.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

// 1 - Subsistemas complexos (Domain Services)
@Service
public class EmailService{
    public void criarEmailCorporativo(UUID idFuncionario){
        System.out.println("Email corporativo criado com sucesso para o usuário " + idFuncionario);
    }
}
