package com.lorranpds.vitaflow.medical_registry.using_spring_rest.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.OnboardingFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

// --- Cliente (Controller) ---
@RestController
@RequestMapping("api/v1/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController{

    // O Controller fica extremamente limpo e injeta apenas o Facade
    private final OnboardingFacade onboardingFacade;

    @PostMapping("/{idFuncionario}/onboarding")
    public ResponseEntity<Void> iniciarOnboarding(@PathVariable UUID idFuncionario){
        onboardingFacade.realizarOnboarding(idFuncionario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
