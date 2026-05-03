package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dto.ConfiguracaoPedidoCommand;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelResponse;

public interface PedidoMovelService {

    PedidoMovelResponse montarConjuntoPorEstilo(ConfiguracaoPedidoCommand estilo);
}
