package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.services.Pedido;
import lombok.extern.slf4j.Slf4j;

// 2. Estados Concretos
@Slf4j
public class EstadoEnviado implements EstadoPedido {

    @Override
    public void entregar(Pedido pedido) {
        pedido.setEstado(new EstadoEntregue());
        log.info("Pacote chegou ao destino. Atualizado pedido [id={}] para 'Entregue'.", pedido.getId());
    }
    // Uma vez enviado, não dá para cancelar diretamente sem logística reversa (simplificamos aqui)
}
