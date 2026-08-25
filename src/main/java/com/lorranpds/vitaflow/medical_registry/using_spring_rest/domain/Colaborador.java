package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain;

/*
    2. Leaf - seria a folha da árvore, o objeto independente, o colaborador individual

    A folha representa um membro sem liderados.
    Seu salário é individual e sua quantidade de subordinados é zero.
 */
public record Colaborador(String nome, String cargo, double salario) implements MembroEquipe {

    @Override
    public int quantidadeSubordinados() {
        return 0; // Folha não tem liderados
    }
}
