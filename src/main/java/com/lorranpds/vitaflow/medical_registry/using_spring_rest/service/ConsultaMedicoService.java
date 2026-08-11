package com.lorranpds.vitaflow.medical_registry.using_spring_rest.service;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.Medico;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.ConselhoMedicoGateway;
import org.springframework.stereotype.Service;

/*
    Regra de negócio (Service)
        O Service não faz ideia de que existe uma API do governo ou HTTP por baixo dos panos.
        Ele só conversa com a interface MedicoConselhoGateway.

        Se amanhã a API do Governo mudar para um banco de dados local ou outra API,
        o Service não precisará mudar uma única linha de código.
 */
@Service
public class ConsultaMedicoService {

    private final ConselhoMedicoGateway medicoConselhoGateway;

    // Injeção de dependência via construtor da interface (Target)
    public ConsultaMedicoService(ConselhoMedicoGateway medicoConselhoGateway) {
        this.medicoConselhoGateway = medicoConselhoGateway;
    }

    public Medico consultaAndValidaSituacao(String crm) {
        Medico medico = medicoConselhoGateway.buscarPorCrm(crm);

        // Exemplo de regra de negócio da aplicação
        if (!medico.ativo()) {
            throw new IllegalStateException("O CRM informado encontra-se inativo no conselho.");
        }

        return medico;
    }
}
