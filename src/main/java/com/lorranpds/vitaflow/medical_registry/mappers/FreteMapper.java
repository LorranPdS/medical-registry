package com.lorranpds.vitaflow.medical_registry.mappers;

import com.lorranpds.vitaflow.medical_registry.dtos.command.FreteCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.request.FreteRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FreteMapper {

    FreteCommand toCommand(FreteRequest request);
}
