package com.lorranpds.vitaflow.medical_registry.execucao_memento;

import com.lorranpds.vitaflow.medical_registry.classic_memento.infrastructure.EditorTexto;
import com.lorranpds.vitaflow.medical_registry.classic_memento.infrastructure.Historico;
import org.junit.jupiter.api.Test;

// Execução - Nessa classe de teste fica a execução para aplicação do Memento
public class ExecucaoMementoTest {

    @Test
    void executarRotinaDeDesfazerEmEdicaoDeTexto(){
        EditorTexto editor = new EditorTexto();
        Historico historico = new Historico();

        editor.escrever("Olá ");
        historico.fazerBackup(editor); // Salva estado: "Olá "

        editor.escrever("Mundo!");
        System.out.println(editor.getConteudo()); // Saída: Olá Mundo!

        historico.desfazer(editor); // Restaura o estado anterior
        System.out.println(editor.getConteudo()); // Saída: Olá
    }
}
