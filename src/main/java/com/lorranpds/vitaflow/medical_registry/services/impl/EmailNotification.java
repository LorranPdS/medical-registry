package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.services.Notification;

public class EmailNotification implements Notification {
    @Override
    public void sendMessage(String msg) {
        // TODO: sending message by email for some project that I don't know how
        System.out.println("Sending message by EMAIL with the message: " + msg);
    }
}
