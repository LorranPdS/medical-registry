package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dto.ConfiguracaoPedidoDTO;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMoveisResponse;

public interface PedidoMoveisService {

    PedidoMoveisResponse montarConjuntoPorEstilo(ConfiguracaoPedidoDTO dto);
}
