package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.notification;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.event.PatientRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener{

    // A anotação @Async é crucial em APIs REST para que o envio de e-mail
    // não trave a resposta (return 201) do Controller!
    @Async
    @EventListener
    public void onPatientRegistered(PatientRegisteredEvent event){
        System.out.println("[NOTIFICATION] Enviando e-mail de boas-vindas para: " + event.patientName());
        // Lógica de integração com AWS SES, SendGrid, etc.
    }
}