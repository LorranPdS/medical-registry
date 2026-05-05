package com.lorranpds.vitaflow.medical_registry.mappers;

import com.lorranpds.vitaflow.medical_registry.dto.NotificationCommand;
import com.lorranpds.vitaflow.medical_registry.dto.NotificationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface NotificationMapper {
    NotificationCommand toCommand(NotificationRequest request);
}
