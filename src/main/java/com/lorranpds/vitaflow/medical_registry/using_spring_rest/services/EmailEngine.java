package com.lorranpds.vitaflow.medical_registry.using_spring_rest.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
    2. Receiver
        O nosso EmailEngine terá as lógicas específicas (e configurações pesadas) de cada provedor de email
        Service do Spring que faz o trabalho real.
 */
@Slf4j
@Service
public class EmailEngine {

    public void sendViaGmail(String recipient, String message) {
        // Lógica complexa: conecta no smtp.gmail.com, usa porta 587, autentica via OAuth2...
        log.info("[ENGINE OAUTH2 - {}] E-mail enviado via GOOGLE para: {}", this.getClass().getSimpleName(), recipient);
    }

    public void sendViaOutlook(String recipient, String message) {
        // Lógica complexa: conecta no smtp.office365.com, valida TLS, TLS handshake...
        log.info("[MARKET ENGINE - {}] E-mail enviado via MICROSOFT AZURE para: {}", this.getClass().getSimpleName(), recipient);
    }
}
