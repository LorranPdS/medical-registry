package com.lorranpds.vitaflow.medical_registry.using_spring_rest.utilitariosexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class PaymentGatewayMock implements PaymentGateway{

    @Override
    public void estornar(BigDecimal valor) {
        // Apenas simula o estorno exibindo no log para você testar seu fluxo!
        log.info("[MOCK GATEWAY] Comunicação com operadora de cartão realizada com sucesso!");
        log.info("[MOCK GATEWAY] Estorno de R$ {} processado.", valor);
    }
}
