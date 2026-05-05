package com.lorranpds.vitaflow.medical_registry.factories;

import com.lorranpds.vitaflow.medical_registry.TypeNotificatioN;
import com.lorranpds.vitaflow.medical_registry.services.Notification;
import com.lorranpds.vitaflow.medical_registry.services.impl.EmailNotification;
import org.springframework.stereotype.Component;

@Component
public class EmailFactory extends NotificationFactory{

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }

    @Override
    public TypeNotificatioN getType() {
        return TypeNotificatioN.EMAIL;
    }
}
