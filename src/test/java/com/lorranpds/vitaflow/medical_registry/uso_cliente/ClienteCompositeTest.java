package com.lorranpds.vitaflow.medical_registry.uso_cliente;

import com.lorranpds.vitaflow.medical_registry.classic_composite.Caixa;
import com.lorranpds.vitaflow.medical_registry.classic_composite.Item;
import com.lorranpds.vitaflow.medical_registry.classic_composite.Produto;
import org.junit.jupiter.api.Test;

public class ClienteCompositeTest {

    @Test
    void inclusaoDeItemEmCarrinhoDeCompras(){
        // Produtos individuais
        Item celular = new Produto("Smartphone", 2000.0);
        Item capinha = new Produto("Capinha", 50.0);
        Item carregador = new Produto("Carregador", 100.0);

        // Caixa pequena de acessórios
        Caixa caixaAcessorios = new Caixa("Caixa de Acessórios");
        caixaAcessorios.adicionar(capinha);
        caixaAcessorios.adicionar(carregador);

        // Caixa grande (contém produto + outra caixa)
        Caixa caixaPrincipal = new Caixa("Caixa do Pedido");
        caixaPrincipal.adicionar(celular);
        caixaPrincipal.adicionar(caixaAcessorios); // Composite dentro de Composite!

        // O cliente trata tudo como 'Item', sem saber a estrutura interna
        System.out.println("Total do pedido: R$ " + caixaPrincipal.preco());
        // Saída: Total do pedido: R$ 2150.0
    }
}
