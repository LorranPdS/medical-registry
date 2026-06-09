package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

// Classe Base do Serviço
// Ela recebe 2 genéricos: O Comando de entrada e a Entidade de saída
@Slf4j
public abstract class AbstractEntityService<DTO, E> {

    @Transactional
    public final E processarCriacao(DTO command) {
        // 1. Valida a regra de negócio baseada no comando
        validar(command);

        // 2. Transforma o Comando limpo na Entidade suja de banco (Passo novo!)
        E entity = converterParaEntidade(command);

        // 3. Salva no banco
        E savedEntity = salvarNoBanco(entity);

        // 4. Hook de notificação
        enviarNotificacao(savedEntity);

        return savedEntity;
    }

    // Passos Abstratos que as filhas DEVEM implementar
    protected abstract void validar(DTO command);
    protected abstract E converterParaEntidade(DTO dto);

    protected E salvarNoBanco(E entity) {
        log.info("### Salvando entidade no banco de dados... ###");
        // repository.save(entity);
        return entity;
    }

    protected void enviarNotificacao(E entity) {
        // Vazio por padrão
    }
}
