package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.services;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.*;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest{

    @Test
    void deveCriarPedidoComEstadoInicialPendente(){
        // Arrange (Preparação)
        UUID idDesejado = UUID.randomUUID();

        // Act (Ação)
        Pedido pedido = new Pedido(idDesejado);

        // Assert (Verificação)
        assertEquals(idDesejado, pedido.getId());
        assertInstanceOf(EstadoPendente.class, pedido.getEstado(),
                "O pedido deve nascer com o status Pendente.");
    }

    @Test
    void deveFazerOFluxoFelizCompletoAteAEntrega(){
        Pedido pedido = new Pedido(UUID.randomUUID());

        // 1. Pendente -> Pago
        pedido.processarPagamento();
        assertInstanceOf(EstadoPago.class, pedido.getEstado());

        // 2. Pago -> Enviado
        pedido.despacharPedido();
        assertInstanceOf(EstadoEnviado.class, pedido.getEstado());

        // 3. Enviado -> Entregue
        pedido.confirmarEntrega();
        assertInstanceOf(EstadoEntregue.class, pedido.getEstado());
    }

    @Test
    void devePermitirCancelarApenasQuandoPendenteOuPago(){
        Pedido pedido1 = new Pedido(UUID.randomUUID());
        pedido1.cancelarPedido(); // Cancelando um Pendente
        assertInstanceOf(EstadoCancelado.class, pedido1.getEstado());

        Pedido pedido2 = new Pedido(UUID.randomUUID());
        pedido2.processarPagamento();
        pedido2.cancelarPedido(); // Cancelando um Pago
        assertInstanceOf(EstadoCancelado.class, pedido2.getEstado());
    }

    // ==========================================
    // TESTANDO OS BLOQUEIOS (SAD PATHS)
    // ==========================================

    @Test
    void naoDevePermitirPagarUmPedidoJaCancelado(){
        Pedido pedido = new Pedido(UUID.randomUUID());
        pedido.cancelarPedido(); // Agora está cancelado

        // Tentar pagar deve estourar a exceção herdada do 'default' da interface
        IllegalStateException exception = assertThrows(IllegalStateException.class, pedido::processarPagamento);
        // Abaixo é a mesma coisa que usando a linha anterior, só que usando Method Reference
        /*
            IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
                pedido.processarPagamento();
            });
         */

        assertEquals("Ação 'Pagar' não permitida no estado atual para o pedido [id="+pedido.getId()+"].", exception.getMessage());
    }

    @Test
    void naoDevePermitirPularDePendenteDiretoParaEnviado(){
        Pedido pedido = new Pedido(UUID.randomUUID());

        // O pedido é recém criado (Pendente). Tentar despachar deve falhar.
        IllegalStateException exception = assertThrows(IllegalStateException.class, pedido::despacharPedido);

        // Vou fazer abaixo o mesmo que foi feito acima
        /*
            IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
                pedido.despacharPedido();
            });
         */
        assertEquals("Ação 'Enviar' não permitida no estado atual para o pedido [id="+pedido.getId()+"].", exception.getMessage());
    }

    @Test
    void naoDevePermitirFazerNadaAposPedidoEntregue(){
        Pedido pedido = new Pedido(UUID.randomUUID());
        pedido.processarPagamento();
        pedido.despacharPedido();
        pedido.confirmarEntrega(); // Chegou no estado final

        // Tentar cancelar um pedido entregue
        assertThrows(IllegalStateException.class, pedido::cancelarPedido);
        // Abaixo é o mesmo que na linha de cima
        /*
            assertThrows(IllegalStateException.class, () -> pedido.cancelarPedido());
         */

        // Tentar pagar um pedido entregue (caso de duplicidade)
        assertThrows(IllegalStateException.class, pedido::processarPagamento);
        // assertThrows(IllegalStateException.class, () -> pedido.processarPagamento());
    }
}
