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

        @Override
        public boolean exigeEstorno() {
            return true; // Só o estado PAGO diz que sim
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
    };
}