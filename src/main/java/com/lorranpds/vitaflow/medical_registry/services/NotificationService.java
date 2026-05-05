package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dto.NotificationCommand;

public interface NotificationService {

    void execute(NotificationCommand notificationCommand);
}
