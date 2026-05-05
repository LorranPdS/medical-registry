package com.lorranpds.vitaflow.medical_registry.factories;

import com.lorranpds.vitaflow.medical_registry.enums.TypeNotification;
import com.lorranpds.vitaflow.medical_registry.services.Notification;
import com.lorranpds.vitaflow.medical_registry.services.impl.SMSNotification;
import org.springframework.stereotype.Component;

// concrete creators
@Component
public class SMSFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }

    @Override
    public TypeNotification getType() {
        return TypeNotification.SMS; // O metodo aqui serve apenas para identificação da fábrica para usar
    }
}
