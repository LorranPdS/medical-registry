package com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture.publishers;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture.observers.PatientObserverNOREST;

// 2. A Interface do Sujeito (Publisher)
public interface MedicalRegistrySubjectNOREST {
    /*
        Tradução: anexar, registrar, vincular ou adicionar.
        Pronúncia: "atétch".
        Função: Coloca um observador na lista para receber notificações.
     */
    void attach(PatientObserverNOREST observer);

    /*
        Tradução: desanexar, remover, desvincular ou cancelar o registro.
        Pronúncia: "ditétch".
        Função: remove um observador da lista para ele parar de receber notificações.
     */
    void detach(PatientObserverNOREST observer);

    /*
        Tradução: Notificar observadores ou avisar ouvintes.
        Pronúncia: "noutifái obzérvêrs".
        Função: Percorre a lista de objetos registrados (gerenciada pelo attach e detach) e dispara uma função em cada um deles, enviando os dados novos.
     */
    void notifyObservers(String patientName, String recordId);
}
