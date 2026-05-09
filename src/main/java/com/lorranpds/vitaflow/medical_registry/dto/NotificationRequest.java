package com.lorranpds.vitaflow.medical_registry.dto;

import com.lorranpds.vitaflow.medical_registry.enums.TypeNotification;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NotificationRequest {

    @NotNull(message = "Field 'type' cannot be null")
    private TypeNotification type;
    @NotEmpty(message = "Field 'message' cannot be null or empty")
    @Size(min = 4, max = 20, message = "Size message must be between {min} and {max}")
    private String message;
}
