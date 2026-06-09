package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

// Classe Base do Serviço
@Slf4j
public abstract class AbstractEntityService<T>{

    // O Template Method encapsulado numa transação do Spring
    @Transactional
    public final T processarCriacao(T entity){
        validar(entity);
        T savedEntity = salvarNoBanco(entity);
        enviarNotificacao(savedEntity); // Hook
        return savedEntity;
    }

    // Passo obrigatório: cada entidade tem sua própria validação
    protected abstract void validar(T entity);

    // Passo padrão: salvar usando o repositório genérico
    protected T salvarNoBanco(T entity){
        log.info("### Salvando entidade no banco de dados... ###");
        // repository.save(entity);
        return entity;
    }

    // Hook: Por padrão, não notifica. Subclasses sobrescrevem se precisarem.
    protected void enviarNotificacao(T entity){
        // Vazio por padrão
    }
}
