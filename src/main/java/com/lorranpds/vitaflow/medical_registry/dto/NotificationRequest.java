package com.lorranpds.vitaflow.medical_registry.dto;

import com.lorranpds.vitaflow.medical_registry.enums.TypeNotification;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationRequest {

    @NotNull
    private TypeNotification type;
    @NotEmpty
    private String message;
}
