package com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.entitiesexample;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.StatusPedido;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Getter
@RequiredArgsConstructor
public class PedidoEntity {

    private final UUID id;
    private StatusPedido status;
    @Setter
    private BigDecimal valor; // Só para fins de exemplo

    public void setStatus(StatusPedido status) {
        this.status = status;
        log.info(">>> Novo status do Pedido: {}", status);
    }
}
