package com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture.observers.BillingServiceNOREST;
import com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture.observers.NotificationServiceNOREST;
import com.lorranpds.vitaflow.medical_registry.here_without_rest_archtecture.publishers.PatientRegistryNOREST;
import org.junit.jupiter.api.Test;

public class ObserverPatternDemoNORESTTest {

    @Test
    void testandoObserverSemArquiteturaRestAndSpring(){
        // Inicializa o publicador
        PatientRegistryNOREST registryNOREST = new PatientRegistryNOREST();

        // Inicializa os observadores
        NotificationServiceNOREST emailServiceNOREST = new NotificationServiceNOREST();
        BillingServiceNOREST billingNOREST = new BillingServiceNOREST();

        // 1. Inscreve os observadores no publicador, ou seja, inscrevendo os 2 serviços
        registryNOREST.attach(emailServiceNOREST);
        registryNOREST.attach(billingNOREST);

        System.out.println("--- Primeiro Registro ---");

        /*
           - a mágica acontece aqui. O Registry não sabe NADA sobre e-mails ou faturamento.
           - ambos vão reagir
        */
        registryNOREST.registerNewPatient("João da Silva", "VF-9982");

        // 2. REGRA DE NEGÓCIO: O serviço de e-mail caiu ou foi desativado temporariamente
        System.out.println("\n[SISTEMA] Removendo o NotificationService da lista de observadores...");
        registryNOREST.detach(emailServiceNOREST);

        System.out.println("\n--- Segundo Registro ---");
        // APENAS o faturamento vai reagir, pois o e-mail foi desanexado!
        registryNOREST.registerNewPatient("Maria Oliveira", "VF-1044");

//        // A mágica acontece aqui. O Registry não sabe NADA sobre e-mails ou faturamento.
//        registryNOREST.registerNewPatient("Lorran P dos Santos", "VF-9982");
    }
}
