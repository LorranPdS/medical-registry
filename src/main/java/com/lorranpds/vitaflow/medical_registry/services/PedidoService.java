package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dtos.PedidoCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.PedidoResponse;

public interface PedidoService {

    PedidoResponse executar(PedidoCommand command);
}
