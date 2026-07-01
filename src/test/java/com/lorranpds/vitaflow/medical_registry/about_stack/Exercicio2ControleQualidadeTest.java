package com.lorranpds.vitaflow.medical_registry.about_stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Exercicio2ControleQualidadeTest {

    @Test
    void testandoCompletoQualidadeDeFabrica(){
        Stack<String> caixaDeProdutos = new Stack<>();

        System.out.println("--- 1. EMPILHANDO PRODUTOS ---");
        // O push adiciona na sequência. Celular vai para o fundo, Tablet fica no topo.
        caixaDeProdutos.push("Celular");
        caixaDeProdutos.push("Notebook");
        caixaDeProdutos.push("Tablet");
        System.out.println("Produtos empilhados com sucesso!");

        System.out.println("\n--- 2. ESPIANDO O TOPO ---");
        // O peek apenas olha o topo ("Tablet") sem alterar a pilha
        String noTopo = caixaDeProdutos.peek();
        System.out.println("Produto no topo: " + noTopo);

        System.out.println("\n--- 3. BUSCANDO POSIÇÃO ---");
        // O search conta a partir do topo (1-based).
        // Tablet está na pos 1, Notebook na pos 2, Celular na pos 3.
        int posicao = caixaDeProdutos.search("Notebook");
        System.out.println("Distância do Notebook até o topo: " + posicao);

        System.out.println("\n--- 4. REMOVENDO DO TOPO ---");
        // O pop remove e retorna o "Tablet" que estava no topo
        String removido = caixaDeProdutos.pop();
        System.out.println("Produto despachado: " + removido);

        System.out.println("\n--- 5. ESVAZIANDO A CAIXA ---");
        // O metodo empty() retorna true se a pilha estiver vazia.
        // Usamos o operador '!' (NOT) para ler "enquanto NÃO estiver vazia"
        while (!caixaDeProdutos.empty()) {
            System.out.println("Removendo no loop: " + caixaDeProdutos.pop());
        }

        System.out.println("\nA caixa está vazia agora? " + caixaDeProdutos.empty());
    }
}
