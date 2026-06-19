package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.handlers;

import java.math.BigDecimal;

// 2. Handler Concreto
public class Diretor extends Aprovador {

    public static final BigDecimal LIMITE_APROVACAO = BigDecimal.valueOf(5000);

    @Override
    public void processarRequisicao(BigDecimal valor){
        if (isValorMenorOuIgualLimite(valor)) {
            System.out.println("Diretor aprovou a compra de R$" + valor);
        } else if (proximoAprovador != null) {
            proximoAprovador.processarRequisicao(valor);
        }
    }

    /*
        O Gemini me deu um exemplo colocando esse metodo privado lá na própria
        classe abstrata com um parâmetro a mais, o que foi até excelente e melhor
        do que essa maneira que eu fiz pensando em usabilidade, MAS eu apenas
        coloquei com metodo privado aqui para eu não me embaralhar nos estudos
        de Chain of Responsibility focando bastante na estrutura.
     */
    private boolean isValorMenorOuIgualLimite(BigDecimal valor) {
        return valor.compareTo(LIMITE_APROVACAO) <= 0;
    }
}
