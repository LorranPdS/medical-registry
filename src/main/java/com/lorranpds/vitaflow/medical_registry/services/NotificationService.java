package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dtos.NotificationRequest;

public interface NotificationService {

    void execute(NotificationRequest notificationRequest);
}
