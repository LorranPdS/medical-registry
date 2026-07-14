package com.lorranpds.vitaflow.medical_registry.classic_adapter.infrastructure;

// 2. Adaptee - a classe externa e incompatível que precisamos usar
public class LegacyUSATaxCalculator{
    public double calculateUSATax(double valueInUSD){
        // Simula um cálculo complexo da biblioteca americana
        return valueInUSD * 0.08;
    }
}
