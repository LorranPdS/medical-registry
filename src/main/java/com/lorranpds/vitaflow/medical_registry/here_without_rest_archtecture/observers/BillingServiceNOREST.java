package com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture.observers;

// 5. Observador Concreto 2: Serviço de Faturamento
public class BillingServiceNOREST implements PatientObserverNOREST {

    @Override
    public void update(String patientName, String recordId){
        System.out.println("BillingService: Iniciando processo de faturamento para o prontuário " + recordId);
    }
}
