package com.lorranpds.vitaflow.medical_registry.dto;

import com.lorranpds.vitaflow.medical_registry.enums.EstiloMoveis;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;

public record PedidoMoveisResponse(EstiloMoveis estiloAplicado, String nomeCadeira, String nomeSofa){

    public PedidoMoveisResponse(EstiloMoveis estilo, Cadeira cadeira, Sofa sofa) {
        this(estilo, cadeira.getClass().getSimpleName(), sofa.getClass().getSimpleName());
    }
}
