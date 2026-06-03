package com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture.observers;

// 1. A Interface do Observador (Observer)
public interface PatientObserverNOREST {
    void update(String patientName, String recordId);
}