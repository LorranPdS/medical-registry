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

    /*
        Depois perguntar ao GEMINI: não seria o caso no metodo toString() abaixo
        eu colocar os atributos referenciando o próprio atributo da classe? Ou seja,
        seria mais ou menos bem visto se eu colocasse "this.numeroPedido",
        "this.cliente" em vez de "numeroPedido" e "cliente" ?
     */
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
