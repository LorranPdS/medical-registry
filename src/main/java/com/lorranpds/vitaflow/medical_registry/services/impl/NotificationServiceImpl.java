package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.TypeNotificatioN;
import com.lorranpds.vitaflow.medical_registry.dto.NotificationCommand;
import com.lorranpds.vitaflow.medical_registry.factories.NotificationFactory;
import com.lorranpds.vitaflow.medical_registry.services.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final Map<TypeNotificatioN, NotificationFactory> factoryMap;

    public NotificationServiceImpl(List<NotificationFactory> factories) {
        this.factoryMap = factories.stream().collect(Collectors.toUnmodifiableMap(NotificationFactory::getType, Function.identity()));
    }

    @Override
    public void execute(NotificationCommand notificationCommand) {
        Optional.ofNullable(factoryMap.get(notificationCommand.type()))
                .orElseThrow(() -> new IllegalArgumentException("Type not found"))
                .processSend(notificationCommand.message());
    }
}
