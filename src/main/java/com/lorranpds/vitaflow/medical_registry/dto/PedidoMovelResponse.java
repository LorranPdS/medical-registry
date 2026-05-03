package com.lorranpds.vitaflow.medical_registry.dto;

import com.lorranpds.vitaflow.medical_registry.enums.EstiloMovelEnum;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;

public record PedidoMovelResponse (EstiloMovelEnum estiloAplicado, String nomeCadeira, String nomeSofa){

    public PedidoMovelResponse(EstiloMovelEnum estilo, Cadeira cadeira, Sofa sofa) {
        this(estilo, cadeira.getClass().getSimpleName(), sofa.getClass().getSimpleName());
    }
}
