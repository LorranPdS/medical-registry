package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

// 2. O Enum atuando como os Estados Concretos
public enum StatusPedido implements OperacoesPedido {

    PENDENTE {
        @Override
        public StatusPedido pagar() {
            return PAGO;
        }

        @Override
        public StatusPedido cancelar() {
            return CANCELADO;
        }
    },

    PAGO {
        @Override
        public StatusPedido enviar() {
            return ENVIADO;
        }

        @Override
        public StatusPedido cancelar() {
            return CANCELADO; /* Lógica de estorno vai no service */
        }

        /* OBSERVAÇÃO
            - Somente no status PAGO é que pode existir a situação de se exigir
            estorno porque aqui é o momento em que tem dinheiro.
            - Pela nossa regra de negócio, depois de ENVIADO não há estorno
            - Não precisa olhar para o significado dos metodos 'enviar()' e 'cancelar()'
            mas sim para o enum principal, que seria o PAGO, que dá significado as outras
            ações que podem ocorrer a partir dele (ser enviado, cancelado e se pode ter estorno)
         */
        @Override
        public boolean exigeEstorno() {
            return true;
        }
    },

    ENVIADO {
        @Override
        public StatusPedido entregar() {
            return ENTREGUE;
        }
    },

    ENTREGUE {
        // Estado final: usa os defaults de erro da interface
    },

    CANCELADO {
        // Estado final: usa os defaults de erro da interface
    }
}
