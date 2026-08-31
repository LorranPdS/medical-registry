package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.services.ActiveDirectoryService;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.services.EmailService;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.services.EquipamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

// --- O Facade (Application Service / Orchestrator) ---
@Component // Ou @Service, dependendo da sua convenção arquitetural
@RequiredArgsConstructor
public class OnboardingFacade{

    private final EmailService emailService;
    private final ActiveDirectoryService adService;
    private final EquipamentoService equipamentoService;

    // O Facade orquestra a regra complexa
    public void realizarOnboarding(UUID idFuncionario){
        emailService.criarEmailCorporativo(idFuncionario);
        adService.concederAcessosIniciais(idFuncionario);
        equipamentoService.solicitarNotebook(idFuncionario);
    }
}
