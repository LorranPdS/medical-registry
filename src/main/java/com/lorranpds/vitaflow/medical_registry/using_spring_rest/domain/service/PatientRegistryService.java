package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.PatientRegistrationCommand;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.event.PatientRegisteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PatientRegistryService{

    // O Spring injeta o Publisher automaticamente
    private final ApplicationEventPublisher eventPublisher;

    public PatientRegistryService(ApplicationEventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public String registerNewPatient(PatientRegistrationCommand command){
        // 1. Lógica de negócio principal: Salvar no banco de dados
        String generatedRecordId = "VF-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        System.out.println("[REGISTRY] Paciente " + command.fullName() + " salvo no banco com ID " + generatedRecordId);

        // 2. Dispara o evento (Notifica os Observers)
        PatientRegisteredEvent event = new PatientRegisteredEvent(command.fullName(), generatedRecordId);
        eventPublisher.publishEvent(event);

        return generatedRecordId;
    }
}