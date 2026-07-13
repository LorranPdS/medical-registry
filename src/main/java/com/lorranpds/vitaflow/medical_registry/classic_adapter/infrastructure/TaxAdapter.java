package com.lorranpds.vitaflow.medical_registry.classic_adapter.infrastructure;

// 3. Adapter (A ponte que une os dois mundos)
public class TaxAdapter implements CalculadorImpostoBRL{
    private final LegacyUSATaxCalculator usaCalculator;
    private final double cotacaoDolar = 5.00; // Simulação de cotação

    public TaxAdapter(LegacyUSATaxCalculator usaCalculator){
        this.usaCalculator = usaCalculator;
    }

    @Override
    public double calcularImpostoReais(double valorEmReais){
        // Converte Real para Dólar (o que o Adaptee entende)
        double valorEmUSD = valorEmReais / cotacaoDolar;

        // Chama o metodo do Adaptee
        double impostoUSD = usaCalculator.calculateUSATax(valorEmUSD);

        // Converte o resultado de volta para Real (o que o Target espera)
        return impostoUSD * cotacaoDolar;
    }
}
