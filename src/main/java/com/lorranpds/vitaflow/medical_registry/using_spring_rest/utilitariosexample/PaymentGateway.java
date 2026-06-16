package com.lorranpds.vitaflow.medical_registry.using_spring_rest.utilitariosexample;

import java.math.BigDecimal;

public interface PaymentGateway {
    void estornar(BigDecimal valor);
}
