package com.lorranpds.vitaflow.medical_registry.classic_composite;

// 2. Leaf - Objeto individual, o nó final da árvore
public record Produto(String nome, double preco) implements Item {
    /*
        - Não precisa de construtor, nem de getters, nem de atributos explicitados
        por ser record porque o Java cuida de tudo
        - Como deixei os métodos da interface "Item" como 'nome' e 'preco' em vez de
        'getNome()' e 'getPreco()', não precisei implementar os getters 'getNome()' e
        'getPreco()' no objeto 'Produto'
        */
}
