package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.commands;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

// 4. Invoker (Pode ser um executor de tarefas do Spring)
@Slf4j
@Component
public class CorporateCommandExecutor {

    public void run(EmailCommand command) {
        long startTime = System.currentTimeMillis();
        log.info("[AUDITORIA - {}] Iniciando o disparo de uma notificação crítica...", this.getClass().getSimpleName());

        // Executa o comando independente de qual seja
        command.execute();

        long duration = System.currentTimeMillis() - startTime;
        log.info("[MÉTRICAS - {}] Disparo concluído com sucesso em {} ms.", this.getClass().getSimpleName(), duration);
    }
}
