package com.lorranpds.vitaflow.medical_registry.clienttest;

import com.lorranpds.vitaflow.medical_registry.classic_proxy.infrastructure.ProxyRelatorioSeguranca;
import com.lorranpds.vitaflow.medical_registry.classic_proxy.model.Agente;
import com.lorranpds.vitaflow.medical_registry.classic_proxy.services.RelatorioInteligencia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.lorranpds.vitaflow.medical_registry.classic_proxy.model.Cargo.ANALISTA_JUNIOR;
import static com.lorranpds.vitaflow.medical_registry.classic_proxy.model.Cargo.DIRETOR;

public class ClienteTest {

    @Test
    public void testaAcessoConcedidoParaCargoAutorizadoParaLeituraDeConteudo(){
        RelatorioInteligencia relatorio = new ProxyRelatorioSeguranca();
        Agente chefe = new Agente("Marta", DIRETOR);

        // Sucesso:
        System.out.println(relatorio.lerConteudo(chefe));
    }

    @Test
    public void testaAcessoNegadoParaCargoNaoAutorizadoParaLeituraDeConteudo(){
        RelatorioInteligencia relatorio = new ProxyRelatorioSeguranca();
        Agente novato = new Agente("João", ANALISTA_JUNIOR);

        // Falha:
        SecurityException exception = Assertions.assertThrows(SecurityException.class, () -> relatorio.lerConteudo(novato));
        System.out.println(exception.getMessage());
        System.err.println(exception.getClass()); // Lança SecurityException
    }
}
