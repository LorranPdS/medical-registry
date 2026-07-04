package com.lorranpds.vitaflow.medical_registry.classic_memento.infrastructure;

import java.util.Stack;

// 3. Caretaker: Gerencia o histórico
public class Historico {

    private Stack<EditorMemento> historico = new Stack<>();

    public void fazerBackup(EditorTexto editor) {
        historico.push(editor.criarSnapshot());
    }

    public void desfazer(EditorTexto editor) {
        if (!historico.isEmpty()) {
            editor.removerSnapshot(historico.pop());
        } else {
            System.out.println("Nada para desfazer!");
        }
    }
}
