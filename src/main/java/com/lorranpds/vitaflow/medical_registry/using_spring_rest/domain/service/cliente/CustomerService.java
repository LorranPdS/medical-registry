package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service.cliente;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities.CustomerEntity;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.AbstractEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Slf4j
@Service
public class CustomerService extends AbstractEntityService<CustomerEntity> {

    private static final BigDecimal LIMITE_MINIMO_CREDITO = BigDecimal.valueOf(2_000);

    @Override
    protected void validar(CustomerEntity customer) {
        if(!StringUtils.hasText(customer.getNome())){
            throw new IllegalArgumentException("Nome de cliente precisa ser informado");
        }
        if(!StringUtils.hasText(customer.getEndereco())){
            throw new IllegalArgumentException("Endereço de cliente precisa ser informado");
        }
        if (isCreditoInvalido(customer.getLimiteCredito())) {
            throw new IllegalArgumentException("Limite de crédito não pode ser inferior a 2.000");
        }
    }

    // O metodo auxiliar (Helper Method) encapsula a dupla validação
    private boolean isCreditoInvalido(BigDecimal limite) {
        return limite == null || limite.compareTo(LIMITE_MINIMO_CREDITO) < 0;
    }
}
