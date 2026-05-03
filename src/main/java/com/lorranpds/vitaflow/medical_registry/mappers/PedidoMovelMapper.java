package com.lorranpds.vitaflow.medical_registry.mappers;

import com.lorranpds.vitaflow.medical_registry.dto.ConfiguracaoPedidoCommand;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMovelMapper {

    // Converte o Request da Web para o Comando do Service
    // Se os nomes dos campos forem iguais (ex: 'estilo'), o MapStruct faz sozinho.
    ConfiguracaoPedidoCommand toCommand(PedidoMovelRequest request);
}