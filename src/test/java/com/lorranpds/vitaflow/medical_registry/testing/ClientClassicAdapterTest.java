package com.lorranpds.vitaflow.medical_registry.testing;

import com.lorranpds.vitaflow.medical_registry.classic_adapter.infrastructure.CalculadorImpostoBRL;
import com.lorranpds.vitaflow.medical_registry.classic_adapter.infrastructure.LegacyUSATaxCalculator;
import com.lorranpds.vitaflow.medical_registry.classic_adapter.infrastructure.TaxAdapter;
import org.junit.jupiter.api.Test;

// 4. Client (O seu código rodando)
public class ClientClassicAdapterTest {

    @Test
    void testCalculoUsandoAdapter(){
        LegacyUSATaxCalculator bibliotecaExterna = new LegacyUSATaxCalculator();
        CalculadorImpostoBRL meuCalculador = new TaxAdapter(bibliotecaExterna);

        double impostoFinal = meuCalculador.calcularImpostoReais(1000.00);
        System.out.println("Imposto convertido em R$: " + impostoFinal);
    }
}
