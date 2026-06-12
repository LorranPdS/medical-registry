package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.services;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.EstadoPedido;
import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.EstadoPendente;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

// 3. O Contexto
@Slf4j
public class Pedido {

    @Getter
    private UUID id;
    private EstadoPedido estado;

    public Pedido(UUID id) {
        this.id = id;
        this.estado = new EstadoPendente(); // Nasce pendente
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
        log.info(">>> Novo status da classe: {}", estado.getClass().getSimpleName());
    }

    // Delegações
    public void processarPagamento(){
        estado.pagar(this);
    }

    public void cancelarPedido(){
        estado.cancelar(this);
    }

    public void despacharPedido(){
        estado.enviar(this);
    }

    public void confirmarEntrega(){
        estado.entregar(this);
    }
}
