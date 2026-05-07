package com.lorranpds.vitaflow.medical_registry.abstractfactories;

import com.lorranpds.vitaflow.medical_registry.enums.EstiloMoveis;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;

/* SOBRE O NOME "MoveisFactory" para o padrão "Abstract Factory":
    - manter o nome 'MoveisFactory'.
    - O que define que ele é um Abstract Factory não é o nome da interface, mas sim o fato de ela
        possuir múltiplos métodos de criação para produtos diferentes (famílias) que devem combinar entre si.
 */
public interface MoveisFactory {
    EstiloMoveis getEstilo();
    Cadeira criarCadeira();
    Sofa criarSofa();
}
