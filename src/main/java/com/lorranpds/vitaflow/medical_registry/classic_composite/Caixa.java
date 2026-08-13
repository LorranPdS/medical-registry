package com.lorranpds.vitaflow.medical_registry.classic_composite;

import java.util.ArrayList;
import java.util.List;

// 3. Composite - contêiner
public class Caixa implements Item {
    private String nome;
    private List<Item> itens = new ArrayList<>();

    public Caixa(String nome){
        this.nome = nome;
    }

    public void adicionar(Item item){
        itens.add(item);
    }

    @Override
    public String nome(){
        return nome;
    }

    @Override
    public double preco(){
        // Delega o cálculo do preço para cada item filho recursivamente
        return itens.stream()
                .mapToDouble(Item::preco)
                .sum();
    }
}