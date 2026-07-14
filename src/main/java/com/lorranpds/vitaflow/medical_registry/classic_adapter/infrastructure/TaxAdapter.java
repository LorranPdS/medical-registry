package com.lorranpds.vitaflow.medical_registry.classic_adapter.infrastructure;

// 3. Adapter - a ponte que une os dois mundos
public class TaxAdapter implements CalculadorImpostoBRL{
    private final LegacyUSATaxCalculator usaCalculator;
    private final double cotacaoDolar = 5.00; // Simulação de cotação

    public TaxAdapter(LegacyUSATaxCalculator usaCalculator){
        this.usaCalculator = usaCalculator;
    }

    @Override
    public double calcularImpostoReais(double valorEmReais){
        // Converte Real para Dólar já que é a moeda em dólar que o Adaptee LegacyUSATaxCalculator entende/usa
        double valorEmUSD = valorEmReais / cotacaoDolar;

        // Depois de convertido para dólar na linha anterior, podemos chamar o metodo do Adaptee 'calculateUSATax'
        double impostoUSD = usaCalculator.calculateUSATax(valorEmUSD);

        // Por fim, converte o resultado de volta para Real, já que Real é a moeda que o Target CalculadorImpostoBRL usa/espera/entende
        return impostoUSD * cotacaoDolar;
    }
}
