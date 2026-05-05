package com.lorranpds.vitaflow.medical_registry.factories;

import com.lorranpds.vitaflow.medical_registry.TypeNotificatioN;
import com.lorranpds.vitaflow.medical_registry.services.Notification;

public abstract class NotificationFactory {

    public abstract Notification createNotification();

    public abstract TypeNotificatioN getType();

    public void processSend(String msg){
        Notification notification = createNotification();
        notification.sendMessage(msg);
    }

}
