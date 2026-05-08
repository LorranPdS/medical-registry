package com.lorranpds.vitaflow.medical_registry.mappers;

import com.lorranpds.vitaflow.medical_registry.dtos.UsuarioCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.UsuarioRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioCommand toCommand(UsuarioRequest request);
}
