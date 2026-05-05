package com.lorranpds.vitaflow.medical_registry.factories;

import com.lorranpds.vitaflow.medical_registry.enums.TypeNotification;
import com.lorranpds.vitaflow.medical_registry.services.Notification;
import com.lorranpds.vitaflow.medical_registry.services.impl.EmailNotification;
import org.springframework.stereotype.Component;

// concrete creators
@Component
public class EmailFactory extends NotificationFactory{

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }

    @Override
    public TypeNotification getType() {
        return TypeNotification.EMAIL; // O metodo aqui serve apenas para identificação da fábrica para usar
    }
}
