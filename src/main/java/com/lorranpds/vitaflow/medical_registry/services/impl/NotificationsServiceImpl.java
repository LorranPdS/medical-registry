package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.enums.TypeNotification;
import com.lorranpds.vitaflow.medical_registry.dtos.NotificationRequest;
import com.lorranpds.vitaflow.medical_registry.factories.NotificationFactory;
import com.lorranpds.vitaflow.medical_registry.services.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationsServiceImpl implements NotificationService {

    private final Map<TypeNotification, NotificationFactory> factoryMap;

    public NotificationsServiceImpl(List<NotificationFactory> factories) {
        this.factoryMap = factories.stream()
                .collect(Collectors.toMap(NotificationFactory::getType, factory -> factory));
    }

    @Override
    public void execute(NotificationRequest notificationRequest) {
        // Se tipo for "WhatsApp", ele busca "WhatsAppFactory" no mapa
        Optional.ofNullable(factoryMap // Usamos ofNullable porque o retorno do mapa pode ser null
                        .get(notificationRequest.getType())) // Se estiver presente, seguimos para o processamento
                        .orElseThrow(() -> new IllegalArgumentException("No notification factory found for type " + notificationRequest.getType())) // Se estiver vazio (null), lançamos a exceção na hora
                        .processSend(notificationRequest.getMessage()); // Aqui já temos a factory garantida (não é null)
    }
}
