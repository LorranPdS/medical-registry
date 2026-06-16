package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.service;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.entitiesexample.PedidoEntity;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.StatusPedido;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.repositoriesexamples.PedidoRepository;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.utilitariosexample.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

// 3. O Service (Stateless) lidando com a Entidade JPA
@RequiredArgsConstructor
@Service
public class PedidoService implements PedidoServiceInterface {

    private final PedidoRepository repository;
    private final PaymentGateway paymentGateway;

    @Transactional
    @Override
    public void realizarPagamento(UUID pedidoId) {
        PedidoEntity pedido = repository.findById(pedidoId).orElseThrow();

        // Aplica o padrão State usando o Enum
        // Se o pedido já for PAGO, ENVIADO, etc., isso vai lançar a IllegalStateException do nosso Enum!
        StatusPedido novoStatus = pedido.getStatus().pagar();
        pedido.setStatus(novoStatus);

        repository.save(pedido);
    }

    @Transactional
    @Override
    public void enviarPedido(UUID pedidoId) {
        PedidoEntity pedido = repository.findById(pedidoId).orElseThrow();

        StatusPedido novoStatus = pedido.getStatus().enviar();
        pedido.setStatus(novoStatus);

        repository.save(pedido);
    }

    @Transactional
    @Override
    public void cancelarPedido(UUID pedidoId) {
        PedidoEntity pedido = repository.findById(pedidoId).orElseThrow();

    /*
	    Em vez de 'if (pedido.getStatus() == StatusPedido.PAGO)', para verificar
	    de qual status estamos cancelando para saber se temos estorno, perguntamos
	    para o comportamento do estado atual para sabermos se ele tem estorno
    */
        if (pedido.getStatus().exigeEstorno()) {
            // chama gateway de pagamento para devolver o dinheiro
            paymentGateway.estornar(pedido.getValor());
        }

        StatusPedido novoStatus = pedido.getStatus().cancelar();
        pedido.setStatus(novoStatus);

        repository.save(pedido);
    }
}