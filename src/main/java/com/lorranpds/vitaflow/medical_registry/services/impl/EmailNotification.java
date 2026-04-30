package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.services.Notification;

// Concrete products
public class EmailNotification implements Notification {

    @Override
    public void sendMessage(String msg) {
        // Implement Email notification logic here
        System.out.println("Sending Email notification: " + msg);
    }
}
