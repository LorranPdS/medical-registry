package com.lorranpds.vitaflow.medical_registry.dto;

import com.lorranpds.vitaflow.medical_registry.TypeNotificatioN;

public record NotificationCommand(TypeNotificatioN type, String message) {
}
