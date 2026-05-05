package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.services.Notification;

public class SMSNotification implements Notification {

    @Override
    public void sendMessage(String msg) {
        // TODO: working how to send message for some other project
        System.out.println("Sending message by SMS: " + msg);
    }
}
