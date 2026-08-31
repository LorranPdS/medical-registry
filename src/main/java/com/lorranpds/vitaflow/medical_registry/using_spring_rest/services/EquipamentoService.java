package com.lorranpds.vitaflow.medical_registry.using_spring_rest.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

// --- Subsistemas (Domain Services) ---
@Service
public class EquipamentoService{
    public void solicitarNotebook(UUID idFuncionario){
        System.out.println("Solicitação de notebook concluída com sucesso para o funcionário " + idFuncionario);
    }
}
