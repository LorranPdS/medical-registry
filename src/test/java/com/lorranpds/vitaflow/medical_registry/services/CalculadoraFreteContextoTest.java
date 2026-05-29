package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.strategies.FretePAC;
import com.lorranpds.vitaflow.medical_registry.strategies.FreteRetiradaNaLoja;
import com.lorranpds.vitaflow.medical_registry.strategies.FreteSedex;
import com.lorranpds.vitaflow.medical_registry.strategies.FreteTransportadoraX;
import org.junit.jupiter.api.Test;

class CalculadoraFreteContextoTest {

    @Test
    void testandoStrategy(){
        double pesoDoPedido = 5.0;       // 5 kg
        double distanciaEntrega = 150.0; // 150 km

        CalculadoraFreteContexto calculadora = new CalculadoraFreteContexto();

        System.out.println("--- Simulando Opções de Frete ---");

        // 1. Testando PAC
        calculadora.setStrategy(new FretePAC());
        double valorPAC = calculadora.executarCalculo(pesoDoPedido, distanciaEntrega);
        System.out.println("Valor PAC: R$ " + String.format("%.2f", valorPAC));
        // Cálculo: 10 + (5 * 0.5) + (150 * 0.1) = 10 + 2.5 + 15 = R$ 27,50

        // 2. Testando Sedex
        calculadora.setStrategy(new FreteSedex());
        double valorSedex = calculadora.executarCalculo(pesoDoPedido, distanciaEntrega);
        System.out.println("Valor Sedex: R$ " + String.format("%.2f", valorSedex));
        // Cálculo: 25 + (5 * 1.2) + (150 * 0.3) = 25 + 6 + 45 = R$ 76,00

        // 3. Testando Transportadora X
        calculadora.setStrategy(new FreteTransportadoraX());
        double valorTX = calculadora.executarCalculo(pesoDoPedido, distanciaEntrega);
        System.out.println("Valor Transportadora X: R$ " + String.format("%.2f", valorTX));
        // Cálculo: 18 + (150 * 0.2) = 18 + 30 = R$ 48,00

        // 4. Testando Retirada
        calculadora.setStrategy(new FreteRetiradaNaLoja());
        double valorRetirada = calculadora.executarCalculo(pesoDoPedido, distanciaEntrega);
        System.out.println("Valor Retirada na Loja: R$ " + String.format("%.2f", valorRetirada));
        // Valor: R$ 0,00
    }

}