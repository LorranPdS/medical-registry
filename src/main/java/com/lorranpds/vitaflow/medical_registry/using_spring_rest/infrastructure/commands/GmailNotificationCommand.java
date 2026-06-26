package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.commands;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.services.EmailEngine;

/*
    3. Concrete Command
        Os Concrete Commands capturam os dados da requisição e sabem qual botão apertar no motor.

        Nota: Em Spring, costumamos não injetar beans em objetos não gerenciados (criados com 'new').
        Passamos o bean gerenciado pelo construtor no Controller.
 */
public class GmailNotificationCommand implements EmailCommand {
    private final EmailEngine engine;
    private final String recipient;
    private final String message;

    public GmailNotificationCommand(EmailEngine engine, String recipient, String message){
        this.engine = engine;
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void execute(){
        engine.sendViaGmail(recipient, message);
    }
}
