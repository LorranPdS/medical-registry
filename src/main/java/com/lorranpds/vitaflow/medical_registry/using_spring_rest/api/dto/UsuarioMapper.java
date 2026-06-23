package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toDTO(UsuarioRequest request);
}
