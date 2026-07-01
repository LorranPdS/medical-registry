package com.lorranpds.vitaflow.medical_registry.mappers;

import com.lorranpds.vitaflow.medical_registry.dto.ConfiguracaoPedidoDTO;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMoveisRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMoveisMapper {

    // Converte o Request da Web para o Comando do Service
    // Se os nomes dos campos forem iguais (ex: 'estilo'), o MapStruct faz sozinho.
    ConfiguracaoPedidoDTO toDTO(PedidoMoveisRequest request);
}