package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service.fornecedor;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.supplier.SupplierDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities.SupplierEntity;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.AbstractEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Slf4j
@Service
public class SupplierService extends AbstractEntityService<SupplierDTO, SupplierEntity> {

    private static final Integer NUMERO_MINIMO_DIAS_RECEBIMENTO = 2;

    @Override
    protected void validar(SupplierDTO dto) {
        if(!StringUtils.hasText(dto.nome())){
            throw new IllegalArgumentException("Nome de cliente precisa ser informado");
        }
        if(!StringUtils.hasText(dto.endereco())){
            throw new IllegalArgumentException("Endereço de cliente precisa ser informado");
        }
        if (isLimiteDiasParaRecebimentoValido(dto.limiteDiasParaRecebimento())) {
            throw new IllegalArgumentException("Limite de crédito não pode ser inferior a 2.000");
        }
        log.info("### Fornecedor {} validado com sucesso", dto.nome());
    }

    @Override
    protected SupplierEntity converterParaEntidade(SupplierDTO supplierDTO) {
        // Aqui você faria a conversão manual ou usaria MapStruct/ModelMapper
        SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setNome(supplierDTO.nome());
        supplierEntity.setEndereco(supplierDTO.endereco());
        supplierEntity.setLimiteDiasParaRecebimento(supplierDTO.limiteDiasParaRecebimento());
        supplierEntity.setDataCriacao(LocalDateTime.now()); // Setando campos do sistema
        supplierEntity.setStatusAtivo(true);
        return supplierEntity;
    }

    private boolean isLimiteDiasParaRecebimentoValido(Integer limiteDiasParaRecebimento) {
        return limiteDiasParaRecebimento == null || limiteDiasParaRecebimento < NUMERO_MINIMO_DIAS_RECEBIMENTO;
    }
}
