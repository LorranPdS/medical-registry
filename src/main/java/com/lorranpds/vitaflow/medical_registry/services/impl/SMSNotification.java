package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.services.Notification;

// Concrete products
public class SMSNotification implements Notification {

    @Override
    public void sendMessage(String msg) {
        // Implement SMS notification logic here
        System.out.println("Sending SMS notification: " + msg);
    }
}
