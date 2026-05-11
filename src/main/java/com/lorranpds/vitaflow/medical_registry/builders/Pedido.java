package com.lorranpds.vitaflow.medical_registry.builders;

import lombok.Getter;

// Product Class - Pedido
@Getter
public class Pedido {
    private final String numeroPedido; // Obrigatório
    private final String cliente;      // Obrigatório
    private final boolean entregaExpressa; // Opcional
    private final String observacao;       // Opcional

    private Pedido(Builder builder){
        this.numeroPedido = builder.numeroPedido;
        this.cliente = builder.cliente;
        this.entregaExpressa = builder.entregaExpressa;
        this.observacao = builder.observacao;
    }

    public Builder toBuilder(){
        return new Builder(this.numeroPedido, this.cliente)
                .comEntregaExpressa(this.entregaExpressa)
                .comObservacao(this.observacao);
    }

    @Override
    public String toString() {
        return "Pedido #" + numeroPedido + " para " + cliente +
                " (Expressa: " + entregaExpressa + ", Obs: " + observacao + ")";
    }

    public static class Builder {
        private String numeroPedido;
        private String cliente;
        private boolean entregaExpressa = false;
        private String observacao = "Nada informado";

        public Builder(String numeroPedido, String cliente){
            this.numeroPedido = numeroPedido;
            this.cliente = cliente;
        }

        public Builder comEntregaExpressa(boolean entrega){
            this.entregaExpressa = entrega;
            return this;
        }

        public Builder comObservacao(String obs){
            this.observacao = obs;
            return this;
        }

        public Pedido build(){
            return new Pedido(this);
        }
    }
}
