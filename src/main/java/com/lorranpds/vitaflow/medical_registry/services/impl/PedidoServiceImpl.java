package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.builders.Pedido;
import com.lorranpds.vitaflow.medical_registry.dtos.PedidoCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.PedidoResponse;
import com.lorranpds.vitaflow.medical_registry.services.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private static final String MENSAGEM_RETORNO = " registrado com sucesso!";

    @Override
    public PedidoResponse executar(PedidoCommand command) {
        Pedido pedido = new Pedido.Builder(command.numeroPedido(), command.cliente())
                .comEntregaExpressa(command.entregaExpressa())
                .comObservacao(command.observacao())
                .build();

        System.out.println(pedido); // Apenas supondo que seja uma linha de .save() na base de dados

        return new PedidoResponse(pedido.getNumeroPedido(), pedido.toString());
    }
}
