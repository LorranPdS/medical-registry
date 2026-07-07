package com.lorranpds.vitaflow.medical_registry.using_spring_rest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/*
    2. ORIGINATOR:
        A entidade principal/real que sofre as mutações de estado

        O Artigo expõe os métodos de snapshot usando nomes semanticamente claros (criarSnapshot e restaurarSnapshot),
        isolando suas propriedades internas.

        A nossa Entidade passa a carregar o seu identificador público universal.
 */
@Getter
public class Artigo {

    // Se optar pela estratégia de ID Duplo:
    private Long idInterno;

    // O UUID nasce blindado aqui no nascimento do objeto com um hash aleatório
    private UUID codigoPublico = UUID.randomUUID();

    // Apenas os textos ganham @Setter, pois são os únicos que o jornalista pode mudar
    @Setter
    private String titulo;
    @Setter
    private String texto;

    // 1. Construtor Vazio: Obrigatório para o JPA/Hibernate trabalhar internamente
    public Artigo() {}

    // 2. Construtor de Negócio: O único que o seu Service vai usar para criar novas matérias
    public Artigo(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    // Regra do Memento: Gera a cápsula do tempo. Permanecem isoladas e protegidas aqui para baixo...
    public ArtigoMemento criarSnapshot() {
        return new ArtigoMemento(this.titulo, this.texto);
    }

    // Regra do Memento: Consome a cápsula do tempo e se atualiza internamente
    public void restaurarSnapshot(ArtigoMemento memento) {
        this.titulo = memento.titulo();
        this.texto = memento.texto();
    }
}
