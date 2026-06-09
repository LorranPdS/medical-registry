package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.supplier;

import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface SupplierMapper {
    SupplierDTO toDTO(SupplierRequest supplierRequest);
}
