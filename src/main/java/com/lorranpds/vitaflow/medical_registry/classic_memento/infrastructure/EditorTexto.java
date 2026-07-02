package com.lorranpds.vitaflow.medical_registry.classic_memento.infrastructure;

// 2. Originator: O objeto real que tem seu estado alterado
public class EditorTexto {

    private String conteudo = "";

    public void escrever(String texto) {
        this.conteudo += texto;
    }

    public String getConteudo() {
        return conteudo;
    }

    // Cria o snapshot
    public EditorMemento salvar() {
        return new EditorMemento(this.conteudo);
    }

    // Restaura o snapshot
    public void restaurar(EditorMemento memento) {
        this.conteudo = memento.getConteudo();
    }
}
