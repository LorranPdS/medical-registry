package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.dto.NotificationCommand;
import com.lorranpds.vitaflow.medical_registry.enums.TypeNotification;
import com.lorranpds.vitaflow.medical_registry.factories.NotificationFactory;
import com.lorranpds.vitaflow.medical_registry.services.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final Map<TypeNotification, NotificationFactory> factoryMap;

    public NotificationServiceImpl(List<NotificationFactory> factories) {
        this.factoryMap = factories.stream()
                .collect(Collectors.toUnmodifiableMap(NotificationFactory::getType, factory -> factory));
//                .collect(Collectors.toUnmodifiableMap(NotificationFactory::getType, Function.identity())); // Outra forma de fazer o que está acima
    }

    @Override
    public void execute(NotificationCommand notificationCommand) {
        // Se tipo for "WhatsApp", ele busca "WhatsAppFactory" no mapa
        Optional.ofNullable(factoryMap // Usamos ofNullable porque o retorno do mapa pode ser null
                        .get(notificationCommand.type())) // Se estiver presente, seguimos para o processamento
                .orElseThrow(() -> new IllegalArgumentException("No notification factory implemented for type '" + notificationCommand.type()+"'")) // Se estiver vazio (null), lançamos a exceção na hora
                .processSend(notificationCommand.message()); // Aqui já temos a factory garantida (não é null)
    }
}
