package com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture.publishers;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture.observers.PatientObserverNOREST;

import java.util.ArrayList;
import java.util.List;

// 3. Sujeito Concreto: O Registro Médico
public class PatientRegistryNOREST implements MedicalRegistrySubjectNOREST {

    private List<PatientObserverNOREST> observers = new ArrayList<>();

    @Override
    public void attach(PatientObserverNOREST observer) {
        observers.add(observer);
    }

    @Override
    public void detach(PatientObserverNOREST observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String patientName, String recordId) {
        for (PatientObserverNOREST observer : observers) {
            observer.update(patientName, recordId);
        }
//        observers.forEach(observer -> observer.update(patientName, recordId));
    }

    // Regra de negócio: Registrar novo paciente
    public void registerNewPatient(String patientName, String recordId){
        System.out.println("PatientRegistry: Registrando o paciente " + patientName + " (ID: " + recordId + ")");
        // Após salvar no banco, notifica todo mundo que precisa saber!
        notifyObservers(patientName, recordId);
    }
}
