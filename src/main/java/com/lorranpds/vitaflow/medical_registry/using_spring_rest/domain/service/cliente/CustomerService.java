package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service.cliente;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.customer.CustomerDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities.CustomerEntity;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.AbstractEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
public class CustomerService extends AbstractEntityService<CustomerDTO, CustomerEntity> {

    private static final BigDecimal LIMITE_MINIMO_CREDITO = BigDecimal.valueOf(2_000);

    @Override
    protected void validar(CustomerDTO dto) {
        if(!StringUtils.hasText(dto.nome())){
            throw new IllegalArgumentException("Nome de cliente precisa ser informado");
        }
        if(!StringUtils.hasText(dto.endereco())){
            throw new IllegalArgumentException("Endereço de cliente precisa ser informado");
        }
        if (isCreditoInvalido(dto.limiteCredito())) {
            throw new IllegalArgumentException("Limite de crédito não pode ser inferior a 2.000");
        }
        log.info("### Cliente {} validado com sucesso", dto.nome());
    }

    @Override
    protected CustomerEntity converterParaEntidade(CustomerDTO customerDTO) {
        // Aqui você faria a conversão manual ou usaria MapStruct/ModelMapper
        CustomerEntity cliente = new CustomerEntity();
        cliente.setNome(customerDTO.nome());
        cliente.setEndereco(customerDTO.endereco());
        cliente.setLimiteCredito(customerDTO.limiteCredito());
        cliente.setDataCriacao(LocalDateTime.now()); // Setando campos do sistema
        cliente.setStatusAtivo(true);
        return cliente;
    }

    // O metodo auxiliar (Helper Method) encapsula a dupla validação
    private boolean isCreditoInvalido(BigDecimal limite) {
        return limite == null || limite.compareTo(LIMITE_MINIMO_CREDITO) < 0;
    }
}
