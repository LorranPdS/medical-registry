package com.lorranpds.vitaflow.medical_registry.mappers;

import com.lorranpds.vitaflow.medical_registry.dtos.commands.ContratoCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.requests.ContratoRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContratoMapper {

    ContratoCommand toCommand(ContratoRequestDTO request);
}
