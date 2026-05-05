package com.lorranpds.vitaflow.medical_registry.factories;

import com.lorranpds.vitaflow.medical_registry.enums.TypeNotification;
import com.lorranpds.vitaflow.medical_registry.services.Notification;

// Creator
public abstract class NotificationFactory {

    // This is the Factory Method (metodo de fábrica - metodo que vai criar a fábrica)
    public abstract Notification createNotification();

    // Cada fábrica diz qual é o seu "Documento de Identidade" (Enum)
    public abstract TypeNotification getType();

    // Metodo facultativo: se não existir, o padrão ainda é factory)
    public void processSend(String msg){
        Notification notification = createNotification();
        notification.sendMessage(msg);
//        createNotification().sendMessage(msg); // Outra forma de fazer o que está acima
    }
}
