package com.lorranpds.vitaflow.medical_registry.infrastructure;

import com.lorranpds.vitaflow.medical_registry.domain.Cargo;
import com.lorranpds.vitaflow.medical_registry.domain.ContratoTrabalho;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class ContratoPrototypeRegistry {

    // Um mapa em memória para guardar nossos protótipos
    private final Map<Cargo, ContratoTrabalho> cache = new EnumMap<>(Cargo.class);

    // O Spring roda esse metodo automaticamente assim que a aplicação inicia
    @PostConstruct
    public void carregarPrototiposIniciais() {
        System.out.println("--- [STARTUP] Inicializando Cache de Protótipos (Vai demorar um pouco) ---");

        // Aqui acontece a parte "lenta" apenas UMA vez no startup
        cache.put(Cargo.DESENVOLVEDOR_JAVA, new ContratoTrabalho(Cargo.DESENVOLVEDOR_JAVA));
        cache.put(Cargo.ARQUITETO_DE_SOFTWARE, new ContratoTrabalho(Cargo.ARQUITETO_DE_SOFTWARE));
        cache.put(Cargo.DIRETOR_FINANCEIRO, new ContratoTrabalho(Cargo.DIRETOR_FINANCEIRO));

        System.out.println("--- [STARTUP] Protótipos cacheados com sucesso! ---");
    }

    // Metodo para recuperar o protótipo pelo Cargo
    public ContratoTrabalho obterPrototipo(Cargo cargo) {
        ContratoTrabalho prototipo = cache.get(cargo);
        if (prototipo == null) {
            throw new IllegalArgumentException("Cargo não suportado ou sem protótipo definido.");
        }
        return prototipo;
    }
}