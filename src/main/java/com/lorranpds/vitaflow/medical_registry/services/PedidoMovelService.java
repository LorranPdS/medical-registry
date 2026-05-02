package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelRequest;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelResponse;

public interface PedidoMovelService {

    PedidoMovelResponse montarConjuntoPorEstilo(PedidoMovelRequest pedidoMovelRequest);
}
