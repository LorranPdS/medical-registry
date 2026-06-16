package com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.repositoriesexamples;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.StatusPedido;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.entitiesexample.PedidoEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PedidoEntityDeBancoDados implements PedidoRepository {

    private static final UUID PEDIDO_STATUS_PENDENTE_NO_BANCO = UUID.fromString("da18c6d5-3444-41b7-9aaa-4f8c0eff9d6b");
    private static final UUID PEDIDO_STATUS_PAGO_NO_BANCO = UUID.fromString("b346039d-f417-4f32-89ad-c812e180f4e2");
    private static final UUID PEDIDO_STATUS_CANCELADO_NO_BANCO = UUID.fromString("e12db10e-4f09-4249-812f-72a1b93dd83a");
    private static final UUID PEDIDO_STATUS_ENVIADO_NO_BANCO = UUID.fromString("b6cde029-75da-4fdf-bd3c-391227a3901f");
    private static final UUID PEDIDO_STATUS_ENTREGUE_NO_BANCO = UUID.fromString("901b12fb-0090-4fe8-9cd4-c1d28833a585");

    // Criamos um mapa estático mapeando cada UUID para o seu respectivo Status de destino
    private static final Map<UUID, StatusPedido> TABELA_STATUS = Map.of(
            PEDIDO_STATUS_PENDENTE_NO_BANCO, StatusPedido.PENDENTE,
            PEDIDO_STATUS_PAGO_NO_BANCO, StatusPedido.PAGO,
            PEDIDO_STATUS_CANCELADO_NO_BANCO, StatusPedido.CANCELADO,
            PEDIDO_STATUS_ENVIADO_NO_BANCO, StatusPedido.ENVIADO,
            PEDIDO_STATUS_ENTREGUE_NO_BANCO, StatusPedido.ENTREGUE
    );

    @Override
    public Optional<PedidoEntity> findById(UUID idPedido) {
        // Se o UUID não estiver na nossa lista de testes, retornamos um Optional vazio (simulando que não achou no banco)
        if (!TABELA_STATUS.containsKey(idPedido)) {
            return Optional.empty();
        }

        PedidoEntity pedidoEntity = new PedidoEntity(idPedido);
        pedidoEntity.setValor(BigDecimal.TEN);

        // Buscamos o status direto no mapa. Se não achar por garantia, joga PENDENTE
        StatusPedido status = TABELA_STATUS.getOrDefault(idPedido, StatusPedido.PENDENTE);
        pedidoEntity.setStatus(status);

        return Optional.of(pedidoEntity);
    }

    @Override
    public void save(PedidoEntity pedidoEntity) {
        // Não faz nada
    }

    // ------------------------- 2) como seria usando o SWITCH e ARROW -------------------------

    /*
        @Override
        public Optional<PedidoEntity> findById(UUID idPedido) {
            PedidoEntity pedidoEntity = getStatusPedidoPeloId(idPedido);
            return Optional.of(pedidoEntity);
        }


        private PedidoEntity getStatusPedidoPeloId(UUID idPedido) {
            PedidoEntity pedidoEntity = new PedidoEntity(idPedido);
            pedidoEntity.setValor(TEN);


            // O switch agora devolve um valor direto para a variável status!
            StatusPedido status = switch (idPedido) {
                case UUID id when id.equals(PEDIDO_STATUS_PENDENTE_NO_BANCO) -> StatusPedido.PENDENTE;
                case UUID id when id.equals(PEDIDO_STATUS_PAGO_NO_BANCO)     -> StatusPedido.PAGO;
                case UUID id when id.equals(PEDIDO_STATUS_CANCELADO_NO_BANCO) -> StatusPedido.CANCELADO;
                case UUID id when id.equals(PEDIDO_STATUS_ENVIADO_NO_BANCO)   -> StatusPedido.ENVIADO;
                case UUID id when id.equals(PEDIDO_STATUS_ENTREGUE_NO_BANCO)  -> StatusPedido.ENTREGUE;
                default -> StatusPedido.PENDENTE; // Um valor padrão caso mandem um UUID qualquer
            };

            pedidoEntity.setStatus(status);
            return pedidoEntity;
    }

     */

    // ------------------------- 1) forma mais primitiva usando cláusulas condicionais IF -------------------------

    /*
        @Override
        public Optional<PedidoEntity> findById(UUID idPedido) {
            PedidoEntity pedidoEntity = getStatusPedidoPeloId(idPedido);
            return Optional.of(pedidoEntity);
        }


        private PedidoEntity getStatusPedidoPeloId(UUID idPedido) {
            PedidoEntity pedidoEntity = new PedidoEntity(idPedido);
            pedidoEntity.setValor(TEN);

            if(idPedido.equals(PEDIDO_STATUS_PENDENTE_NO_BANCO)){
                pedidoEntity.setStatus(StatusPedido.PENDENTE);
            }

            if(idPedido.equals(PEDIDO_STATUS_PAGO_NO_BANCO)){
                pedidoEntity.setStatus(StatusPedido.PAGO);
            }

            if(idPedido.equals(PEDIDO_STATUS_CANCELADO_NO_BANCO)){
                pedidoEntity.setStatus(StatusPedido.CANCELADO);
            }

            if(idPedido.equals(PEDIDO_STATUS_ENVIADO_NO_BANCO)){
                pedidoEntity.setStatus(StatusPedido.ENVIADO);
            }

            if(idPedido.equals(PEDIDO_STATUS_ENTREGUE_NO_BANCO)){
                pedidoEntity.setStatus(StatusPedido.ENTREGUE);
            }

            return pedidoEntity;
    }
     */
}
