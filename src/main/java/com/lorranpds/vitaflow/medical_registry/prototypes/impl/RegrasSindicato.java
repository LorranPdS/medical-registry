package com.lorranpds.vitaflow.medical_registry.prototypes.impl;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RegrasSindicato {

    private String nomeSindicato;
    private List<String> clausulas; // objeto mutável

    // Construtor usado para carregar dados "do banco"
    public RegrasSindicato(String nome, List<String> clausulas){
        this.nomeSindicato = nome;
        this.clausulas = clausulas;
    }

    // CONSTRUTOR DE CÓPIA: Fundamental para a cópia profunda
    public RegrasSindicato(RegrasSindicato outro){
        this.nomeSindicato = outro.nomeSindicato;
        // Criamos uma NOVA lista em memória para este clone
        this.clausulas = new ArrayList<>(outro.clausulas);
    }

    /*
      Podemos permitir adicionar cláusulas extras específicas para uma pessoa,
      por isso a cópia profunda acima é tão importante.
    */
    public void adicionarClausulaEspecifica(String clausula) {
        this.clausulas.add(clausula);
    }
}
