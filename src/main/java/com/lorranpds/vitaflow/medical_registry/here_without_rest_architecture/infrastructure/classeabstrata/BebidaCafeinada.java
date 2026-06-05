package com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.infrastructure.classeabstrata;

import java.util.ArrayList;
import java.util.List;

// 1. A Classe Abstrata com o Template Method
public abstract class BebidaCafeinada {

    // Lista para rastrear a ordem dos passos executados (feito para os T.U)
    private final List<String> passosExecutados = new ArrayList<>();

    // O Template Method: marcado como 'final' para não ser alterado
    public final void prepararReceita(){
        ferverAgua();
        preparar();
        colocarNaXicara();
        if (clienteQuerCondimentos()) { // Hook (Gancho)
            adicionarCondimentos();
        }
    }

    // Passos que as subclasses DEVEM implementar
    protected abstract void preparar();
    protected abstract void adicionarCondimentos();

    // Passos comuns que já vêm prontos
    private void ferverAgua(){
        System.out.println("Fervendo a água...");
        passosExecutados.add("Fervendo água");
    }

    private void colocarNaXicara(){
        System.out.println("Colocando a bebida na xícara...");
        passosExecutados.add("Colocando na xícara");
    }

    // Hook (Gancho): implementação padrão que pode ser sobrescrita
    protected boolean clienteQuerCondimentos(){
        return true;
    }

    // Metodo getter para o teste unitário conseguir validar o resultado
    public List<String> getPassosExecutados(){
        return passosExecutados;
    }
}
