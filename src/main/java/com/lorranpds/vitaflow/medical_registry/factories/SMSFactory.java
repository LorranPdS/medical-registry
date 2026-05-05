package com.lorranpds.vitaflow.medical_registry.factories;

import com.lorranpds.vitaflow.medical_registry.TypeNotificatioN;
import com.lorranpds.vitaflow.medical_registry.services.Notification;
import com.lorranpds.vitaflow.medical_registry.services.impl.SMSNotification;
import org.springframework.stereotype.Component;

@Component
public class SMSFactory extends NotificationFactory{

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }

    @Override
    public TypeNotificatioN getType() {
        return TypeNotificatioN.SMS;
    }
}
