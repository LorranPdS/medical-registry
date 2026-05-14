package com.lorranpds.vitaflow.medical_registry.singleton;

import com.lorranpds.vitaflow.medical_registry.connectionexample.ConnectionExample;
import com.lorranpds.vitaflow.medical_registry.connectionexample.DriverManagerExample;

// Forma 2: Double-Checked Locking - mais performática que a forma 1
public class DoubleCheckedLockingSingleton {

    // volatile é crucial para o funcionamento correto do Double-Checked
    private static volatile DoubleCheckedLockingSingleton instance;
    private ConnectionExample connection;

    private DoubleCheckedLockingSingleton(){
        try {
            String url = "jdbc:postgresql://localhost:5432/vitaflow";
            this.connection = DriverManagerExample.getConnection(url, "admin", "123");
        }catch (ExceptionInInitializerError e){
            throw new ExceptionInInitializerError("Falha ao conectar no banco de dados. " + e.getMessage());
        }
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) { // 1ª Checagem (Sem trava)
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { // 2ª Checagem (Com trava)
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    public ConnectionExample getConnection() {
        return this.connection;
    }
}
