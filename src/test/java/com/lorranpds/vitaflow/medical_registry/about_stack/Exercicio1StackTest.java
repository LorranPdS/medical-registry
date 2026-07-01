package com.lorranpds.vitaflow.medical_registry.about_stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Hoje em dia se usa a collection Deque em vez da collection Stack por ter mais
    nova e com performance superior

    Exemplo:
    Deque<String> pilhaModerna = new ArrayDeque<>();
 */
public class Exercicio1StackTest {

    @Test
    void meuExercicioUsandoStack(){
        // push(...) - adiciona livros na pilha
        Stack<String> livrosEmpilhados = new Stack<>();
        livrosEmpilhados.push("Livro 1");
        livrosEmpilhados.push("Livro 2");
        livrosEmpilhados.push("Livro 3");
        livrosEmpilhados.push("Livro 4");
        System.out.println(livrosEmpilhados);
        // -------------------------------------------------------------------

        // peek() - visualiza o que está no topo da pilha para visualizar
        System.out.println(livrosEmpilhados.peek());
        // -------------------------------------------------------------------

        // search(...) - informa o índice que o item selecionado está. Se não estiver na pilha, retorna -1
        System.out.println(livrosEmpilhados.search("Livro 3")); // retornou 2
        System.out.println(livrosEmpilhados.search("Livro 21")); // retornou -1
        // -------------------------------------------------------------------

        // pop() - remove o primeiro elemento da pilha
        livrosEmpilhados.pop();
        System.out.println(livrosEmpilhados);
        // -------------------------------------------------------------------

        // isEmpty() - retorna um boolean dizendo se a stack está vazia ou não
        System.out.println(livrosEmpilhados.isEmpty());

        // size() - lembrar que esse metodo vem do VETOR, que seria de onde o Stack estende
        System.out.println(livrosEmpilhados.size());
    }

    @Test
    void inverterPalavra(){
        String palavra = "JAVA";
        Stack<Character> pilhaLetras = new Stack<>();

        // 1. Coloca cada letra dentro da pilha
        for (int i = 0; i < palavra.length(); i++) {
            pilhaLetras.push(palavra.charAt(i));
        }

        // 2. Remove da pilha concatenando na nova string
        String palavraInvertida = "";
        while (!pilhaLetras.isEmpty()) {
            palavraInvertida += pilhaLetras.pop();
        }

        System.out.println("Original: " + palavra);
        System.out.println("Invertida: " + palavraInvertida); // Saída: AVAJ

        assertEquals("JAVA", palavra);
        assertEquals("AVAJ", palavraInvertida);
    }

    @Test
    void historicoNavegadorWeb(){
        Stack<String> historico = new Stack<>();

        // Usuário navegando
        historico.push("google.com");
        historico.push("github.com");
        historico.push("stackoverflow.com");

        // Espiando a página atual (topo)
        System.out.println("Página atual: " + historico.peek()); // Saída: stackoverflow.com
        System.out.println();
        assertEquals("stackoverflow.com", historico.peek());

        // ----------------------------------------------------------------------------------

        // Usuário clica em "Voltar" uma vez
        System.out.println("[Voltar] Fechando: " + historico.pop());
        System.out.println("Nova página atual: " + historico.peek()); // Saída: github.com
        System.out.println();
        assertEquals("github.com", historico.peek());

        // Usuário clica em "Voltar" de novo
        System.out.println("[Voltar] Fechando: " + historico.pop());
        System.out.println("Nova página atual: " + historico.peek()); // Saída: google.com
        assertEquals("google.com", historico.peek());
    }

    @Test
    void validadorDeParentesesSimples(){
        String expressaoCorreta = "((x + y) * z)";
        String expressaoIncorreta = "((x + y)";

        System.out.println("Expressão 1 é válida? " + validarParenteses(expressaoCorreta)); // true
        System.out.println("Expressão 2 é válida? " + validarParenteses(expressaoIncorreta)); // false
    }

    public static boolean validarParenteses(String expressao) {
        Stack<String> pilha = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            // Se abrir parêntese, empilha
            if (caractere == '(') {
                pilha.push("(");
            }
            // Se fechar parêntese...
            else if (caractere == ')') {
                // Se encontrar um ')' mas a pilha já estiver vazia, significa que
                // fechou um parêntese que nunca foi aberto. Expressão inválida!
                if (pilha.isEmpty()) {
                    return false;
                }
                pilha.pop(); // Par correto encontrado, remove da pilha
            }
        }

        // Se no final do texto a pilha estiver completamente vazia,
        // significa que todos os parênteses abriram e fecharam perfeitamente.
        return pilha.isEmpty();
    }
}
