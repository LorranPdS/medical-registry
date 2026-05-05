package com.lorranpds.vitaflow.medical_registry.dto;

import com.lorranpds.vitaflow.medical_registry.enums.TypeNotification;

public record NotificationCommand(TypeNotification type, String message) {
}
