package com.lorranpds.vitaflow.medical_registry.clienttest;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_archtechture.infrastructure.*;
import org.junit.jupiter.api.Test;

// 5. O Client (O fluxo da aplicação)
public class TradingSystemAppTest {

    @Test
    void testandoCommandClassico(){
        // 1. Instancia o motor (Receiver)
        MarketEngine b3Engine = new MarketEngine();

        // 2. Cria os comandos de negócio com base no input do cliente (Concrete Commands)
        // Exemplo: O cliente quer vender PETR4 e comprar um FII.
        OrderCommand sellPetr4 = new SellOrderCommand(b3Engine, "PETR4", 10);
        OrderCommand buyFii = new BuyOrderCommand(b3Engine, "KNRI11", 5);

        // 3. Instancia a fila da corretora (Invoker)
        BrokerQueue xpQueue = new BrokerQueue();

        // 4. O cliente envia as ordens. A corretora apenas aceita, mas o motor ainda não rodou.
        xpQueue.takeOrder(sellPetr4);
        xpQueue.takeOrder(buyFii);

        // ... tempo passa ... validações de compliance ocorrem ...

        // 5. O sistema processa as ordens no momento correto
        xpQueue.processOrders();
    }
}
