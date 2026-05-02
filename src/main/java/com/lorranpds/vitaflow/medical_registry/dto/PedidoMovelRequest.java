package com.lorranpds.vitaflow.medical_registry.dto;

import com.lorranpds.vitaflow.medical_registry.enums.EstiloMovelEnum;
import lombok.Data;

@Data
public class PedidoMovelRequest {

    private EstiloMovelEnum estilo;
}
