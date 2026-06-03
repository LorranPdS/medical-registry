package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.billing;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.event.PatientRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BillingListener{

    @Async
    @EventListener
    public void handleBillingInitiation(PatientRegisteredEvent event){
        System.out.println("[BILLING] Iniciando a abertura de conta para o prontuário: " + event.recordId());
        // Lógica de faturamento e regras financeiras
    }
}