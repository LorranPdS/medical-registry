package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.factories;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.enums.EmailProvider;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.commands.EmailCommand;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.services.EmailEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Aqui também não é Command, mas sim um Factory Method
@Component
public class EmailCommandFactory{

    private final EmailEngine emailEngine;

    // O Spring injeta o Enum correto aqui na inicialização do sistema (Boot-time)
    @Value("${app.email.active-provider}")
    private EmailProvider activeProvider;

    public EmailCommandFactory(EmailEngine emailEngine){
        this.emailEngine = emailEngine;
    }

    public EmailCommand createActiveCommand(String to, String msg){
        // ZERO IF/ELSE! O polimorfismo do Enum decide quem instanciar dinamicamente
        return activeProvider.create(emailEngine, to, msg);
    }
}
