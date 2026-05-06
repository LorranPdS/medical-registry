package com.lorranpds.vitaflow.medical_registry.factories;

import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelResponse;
import com.lorranpds.vitaflow.medical_registry.enums.EstiloMovelEnum;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;

/* SOBRE O NOME "MoveisFactory" para o padrão "Abstract Factory":
    - manter o nome 'MoveisFactory'.
    - O que define que ele é um Abstract Factory não é o nome da interface, mas sim o fato de ela
        possuir múltiplos métodos de criação para produtos diferentes (famílias) que devem combinar entre si.
 */
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
