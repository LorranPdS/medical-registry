package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelResponse;
import com.lorranpds.vitaflow.medical_registry.enums.EstiloMovelEnum;
import com.lorranpds.vitaflow.medical_registry.records.ConfiguracaoPedidoRecord;

public interface PedidoMovelService {

    PedidoMovelResponse montarConjuntoPorEstilo(ConfiguracaoPedidoRecord estilo);
}
