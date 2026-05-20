package com.lorranpds.vitaflow.medical_registry.domain;

import com.lorranpds.vitaflow.medical_registry.domain.interfaces.Prototipo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ContratoTrabalho implements Prototipo<ContratoTrabalho> {

    private Cargo cargo;
    private RegrasSindicato regrasSindicato; // Objeto Complexo
    @Setter
    private String nomeFuncionario;          // Dado Mutável

    // 1. Construtor Original (Lento, vai no "banco de dados")
    public ContratoTrabalho(Cargo cargo) {
        this.cargo = cargo;
        this.regrasSindicato = buscarRegrasSindicatoNoBanco(cargo);
    }

    // Simula a ida ao banco de dados ou microsserviço
    private RegrasSindicato buscarRegrasSindicatoNoBanco(Cargo cargo) {
        System.out.println("Buscando regras para " + cargo + " (Pausa de 2s)...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<String> clausulasBase = new ArrayList<>();
        clausulasBase.add("Carga horária de 40h semanais");
        clausulasBase.add("Benefícios padrão da categoria");

        return new RegrasSindicato("Sindpd", clausulasBase);
    }

    // 2. Construtor de Cópia PRIVADO (Rápido, ocorre em memória)
    private ContratoTrabalho(ContratoTrabalho target) {
        if (target != null) {
            this.cargo = target.cargo; // Enums são seguros para copiar direto
            this.nomeFuncionario = target.nomeFuncionario;

            // CÓPIA PROFUNDA: Usamos o construtor de cópia da classe RegrasSindicato
            this.regrasSindicato = new RegrasSindicato(target.regrasSindicato);
        }
    }

    @Override
    public ContratoTrabalho clonar() {
        return new ContratoTrabalho(this);
    }

    public void imprimirResumo() {
        System.out.println("--- Contrato de " + nomeFuncionario + " ---");
        System.out.println("Cargo: " + cargo);
        System.out.println("Sindicato: " + regrasSindicato.getNomeSindicato());
        System.out.println("Cláusulas: " + regrasSindicato.getClausulas());
        System.out.println("---------------------------------");
    }
}
