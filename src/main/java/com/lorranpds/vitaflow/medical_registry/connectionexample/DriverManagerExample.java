package com.lorranpds.vitaflow.medical_registry.connectionexample;

import lombok.Getter;

public class DriverManagerExample implements ConnectionExample {

    private final String url;
    @Getter
    private final String user;
    private final String password;

    private DriverManagerExample(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public static ConnectionExample getConnection(String url, String user, String password){
        return new DriverManagerExample(url, user, password);
    }
}
