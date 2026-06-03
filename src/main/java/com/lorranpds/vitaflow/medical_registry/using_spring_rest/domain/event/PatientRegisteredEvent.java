package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.event;

// Este é o pacote de dados que será transmitido aos observadores
public record PatientRegisteredEvent(String patientName, String recordId){
}
