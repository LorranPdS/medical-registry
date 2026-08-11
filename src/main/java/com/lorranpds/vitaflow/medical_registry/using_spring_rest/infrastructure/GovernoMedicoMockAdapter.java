package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.Medico;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// A anotação @Primary faz o Spring injetar esta classe no lugar do Adapter real que faz a chamada HTTP
@Primary
@Component
public class GovernoMedicoMockAdapter implements ConselhoMedicoGateway {

    @Override
    public Medico buscarPorCrm(String crm) {
        // Retorna um objeto fake em memória sem fazer chamada HTTP
        return new Medico(
                crm,
                "Dr. John Wesley (Mock)",
                true
        );
    }
}