package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.services.Pedido;
import lombok.extern.slf4j.Slf4j;

// 2. Estados Concretos
@Slf4j
public class EstadoPendente implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        // Ação executada primeiro
        pedido.setEstado(new EstadoPago());

        // Log estruturado com contexto: Qual pedido mudou?
        log.info("Pagamento aprovado. Pedido [id={}] atualizado para 'Pago'.", pedido.getId());
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new EstadoCancelado());
        log.info("Pedido [id={}] alterado de pendente para cancelado.", pedido.getId());
    }
}
