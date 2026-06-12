package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.services.Pedido;
import lombok.extern.slf4j.Slf4j;

// 2. Estados Concretos
@Slf4j
public class EstadoPago implements EstadoPedido {

    @Override
    public void enviar(Pedido pedido) {
        pedido.setEstado(new EstadoEnviado());
        log.info("Nota fiscal emitida. Pedido [id={}] despachado e atualizado para 'Enviado'.", pedido.getId());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new EstadoCancelado());
        log.info("Pedido [id={}] foi cancelado. Estornando o cartão do cliente...", pedido.getId());
    }
}
