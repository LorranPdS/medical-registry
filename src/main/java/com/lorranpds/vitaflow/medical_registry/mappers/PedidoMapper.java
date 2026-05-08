package com.lorranpds.vitaflow.medical_registry.mappers;

import com.lorranpds.vitaflow.medical_registry.dtos.PedidoCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.PedidoRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    PedidoCommand toCommand(PedidoRequest request);
}
