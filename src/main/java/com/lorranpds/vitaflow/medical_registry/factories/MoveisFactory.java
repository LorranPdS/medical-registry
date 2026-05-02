package com.lorranpds.vitaflow.medical_registry.factories;

import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelResponse;
import com.lorranpds.vitaflow.medical_registry.enums.EstiloMovelEnum;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;

public interface MoveisFactory {
    EstiloMovelEnum getEstilo();
    Cadeira criarCadeira();
    Sofa criarSofa();

    default PedidoMovelResponse montarConjunto(){
        return new PedidoMovelResponse(
                this.getEstilo(),
                this.criarCadeira(),
                this.criarSofa()
        );
    }
}
