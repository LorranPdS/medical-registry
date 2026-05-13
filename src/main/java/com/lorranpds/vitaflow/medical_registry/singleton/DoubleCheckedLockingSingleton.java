package com.lorranpds.vitaflow.medical_registry.singleton;
// Forma 2: Double-Checked Locking - mais performática que a forma 1
public class DoubleCheckedLockingSingleton {

    private static volatile DoubleCheckedLockingSingleton instance;
    private String configuration;

    private DoubleCheckedLockingSingleton(){
        this.configuration = "BANCO";
    }

    public static DoubleCheckedLockingSingleton getInstance(){
        if (instance == null) { // Primeiro cheque (sem trava)
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { // Segundo cheque (com trava)
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    public void showConfiguration(){
        System.out.println("A configuração atual é " + configuration);
    }
}
