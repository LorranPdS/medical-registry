package com.lorranpds.vitaflow.medical_registry.using_spring_rest.model;

import lombok.Data;

import java.util.UUID;

/*
    2. ORIGINATOR:
        A entidade principal/real que sofre as mutações de estado

        O Artigo expõe os métodos de snapshot usando nomes semanticamente claros (criarSnapshot e restaurarSnapshot),
        isolando suas propriedades internas.

        A nossa Entidade passa a carregar o seu identificador público universal.
 */
@Data
public class Artigo {

    // Se optar pela estratégia de ID Duplo:
    private Long idInterno;
    private UUID codigoPublico = UUID.randomUUID(); // Nasce blindado com um hash aleatório
    private String titulo;
    private String texto;

    public Artigo() {}

    public Artigo(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    // Regra do Memento: Gera a cápsula do tempo
    public ArtigoMemento criarSnapshot() {
        return new ArtigoMemento(this.titulo, this.texto);
    }

    // Regra do Memento: Consome a cápsula do tempo e se atualiza internamente
    public void restaurarSnapshot(ArtigoMemento memento) {
        this.titulo = memento.titulo();
        this.texto = memento.texto();
    }
}
