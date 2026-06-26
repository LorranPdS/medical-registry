package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.enums;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.commands.EmailCommand;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.commands.GmailNotificationCommand;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.commands.OutlookNotificationCommand;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.services.EmailEngine;

// Essa parte do Enum não seria uma implementação de Command, é apenas um Factory Method
public enum EmailProvider{

    GMAIL {
        @Override
        public EmailCommand create(EmailEngine engine, String to, String msg){
            return new GmailNotificationCommand(engine, to, msg);
        }
    },
    OUTLOOK {
        @Override
        public EmailCommand create(EmailEngine engine, String to, String msg){
            return new OutlookNotificationCommand(engine, to, msg);
        }
    };

    // Metodo abstrato que força cada constante a saber fabricar seu próprio comando
    public abstract EmailCommand create(EmailEngine engine, String to, String msg);
}