package com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture.observers;

// 4. Observador Concreto 1: Serviço de Notificação
public class NotificationServiceNOREST implements PatientObserverNOREST {

    @Override
    public void update(String patientName, String recordId){
        System.out.println("NotificationService: Enviando e-mail de boas-vindas para " + patientName);
    }
}
