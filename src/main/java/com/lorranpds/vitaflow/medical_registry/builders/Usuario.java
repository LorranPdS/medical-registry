package com.lorranpds.vitaflow.medical_registry.builders;

import lombok.Getter;

// Essa classe será um modelo de Builder Template
@Getter
public class Usuario {

    private final String nome;      // Diferente para cada um
    private final String pais;      // Quase sempre "Brasil"
    private final String idioma;    // Quase sempre "PT-BR"
    private final boolean ativo;    // Quase sempre "true"

    private Usuario(Builder builder){
        this.nome = builder.nome;
        this.pais = builder.pais;
        this.idioma = builder.idioma;
        this.ativo = builder.ativo;
    }

    public Builder toBuilder(){
        return new Builder()
                .comNome(this.nome)
                .comPais(this.pais)
                .comIdioma(this.idioma)
                .isAtivo(this.ativo);
    }

    // ESSE METODO AQUI É O BUILDER TEMPLATE - UM METODO COM INFORMAÇOES PRONTAS
    public static Usuario.Builder builderPadraoBrasil(){
        return new Usuario.Builder()
                .comPais("Brasil")
                .comIdioma("PT-BR")
                .isAtivo(true);
    }

    @Override
    public String toString() {
        return "Usuario registrado: "
                + "nome = " + nome
                + ", pais = " + pais
                + ", idioma = " + idioma
                + " com o perfil ativo = " + ativo;
    }

    public static class Builder {
        private String nome;
        private String pais;
        private String idioma;
        private boolean ativo;

        public Builder comNome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder comPais(String pais){
            this.pais = pais;
            return this;
        }

        public Builder comIdioma(String idioma){
            this.idioma = idioma;
            return this;
        }

        public Builder isAtivo(boolean ativo){
            this.ativo = ativo;
            return this;
        }

        public Usuario build(){
            return new Usuario(this);
        }
    }
}
