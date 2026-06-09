package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.customer;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(CustomerRequest customerRequest);
}
