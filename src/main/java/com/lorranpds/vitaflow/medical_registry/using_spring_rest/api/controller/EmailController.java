package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.commands.CorporateCommandExecutor;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.commands.EmailCommand;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.factories.EmailCommandFactory;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    5. O Client (O REST Controller do Spring)
        O Controller recebe o JSON ou os parâmetros do usuário.
        É ele quem descobre o que o usuário quer e monta o Command Concreto correto, entregando-o de bandeja para o Invoker.
 */
@RestController
@RequestMapping("/api/v1/emails")
public class EmailController{

    private final EmailCommandFactory commandFactory;
    private final CorporateCommandExecutor executor; // Invoker

    // Injeção de dependências via construtor do Spring
    public EmailController(EmailCommandFactory commandFactory, CorporateCommandExecutor executor){
        this.commandFactory = commandFactory;
        this.executor = executor;
    }

    @PostMapping("/dispatch")
    public ResponseEntity<String> dispatchEmail(@RequestBody @Valid EmailRequest request){

        // 1. Buscamos os dados encapsulados de dentro da Heap (onde o Spring instanciou o Record)
        // O Controller não faz ideia de qual provedor está rodando nos bastidores!
        EmailCommand command = commandFactory.createActiveCommand(request.to(), request.msg());

        // 2. O Invoker do padrão Command entra em ação
        executor.run(command);

        return ResponseEntity.ok("Notificação enviada com sucesso utilizando a infraestrutura ativa.");
    }
}
