package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    3. Composite
        O Composite possui seu próprio salário, além de manter uma lista de membros
        em sua equipe. O cálculo do salário total da equipe e a contagem de
        subordinados delegam a execução recursivamente para cada membro da lista.
 */
public class Gestor implements MembroEquipe{

    private final String nome;
    private final String cargo;
    private final double salario;
    private final List<MembroEquipe> equipe = new ArrayList<>();

    public Gestor(String nome, String cargo, double salario){
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void adicionarMembro(MembroEquipe membro){
        equipe.add(membro);
    }

    public void removerMembro(MembroEquipe membro){
        equipe.remove(membro);
    }

    public List<MembroEquipe> getEquipe(){
        return Collections.unmodifiableList(equipe);
    }

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public String cargo() {
        return cargo;
    }

    @Override
    public double salario(){
        // Custo total = Salário do gestor + Salário de todos os liderados (recursivo)
        double custoTotalEquipe = equipe.stream()
                .mapToDouble(MembroEquipe::salario)
                .sum();

        return this.salario + custoTotalEquipe;
    }

    @Override
    public int quantidadeSubordinados(){
        // Quantidade total = Soma dos liderados diretos/indiretos
        int totalSubordinados = equipe.stream()
                .mapToInt(membro -> 1 + membro.quantidadeSubordinados())
                .sum();

        return totalSubordinados;
    }
}
