package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/*
    Classe de configuração para que o armazenamento de cache não fique toda vida guardando dados.

    Nesse caso eu usei o Caffeine com armazenamento na memória RAM da JVM (heap memory), mas para ambientes
        de Produção, o melhor seria o "REDIS". Coloquei o motivo disso no Notion nas dúvidas que
        foram surgindo com a implementação do Proxy, bem como um exemplo de como implementá-lo.
 */
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("climaCache");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                // 1. Expiração automática após 30 minutos da escrita
                .expireAfterWrite(Duration.ofMinutes(30))
                // 2. Limite máximo de 500 cidades para proteger a memória RAM
                .maximumSize(500));
        return cacheManager;
    }
}
