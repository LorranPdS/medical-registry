package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.user;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {

   UserDTO toDTO(UserRequest request);
}
