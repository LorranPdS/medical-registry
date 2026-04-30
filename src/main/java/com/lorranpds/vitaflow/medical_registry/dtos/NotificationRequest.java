package com.lorranpds.vitaflow.medical_registry.dtos;

import com.lorranpds.vitaflow.medical_registry.enums.TypeNotification;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationRequest {

    @NotNull
    private TypeNotification type;
    @NotBlank
    private String message;
}
