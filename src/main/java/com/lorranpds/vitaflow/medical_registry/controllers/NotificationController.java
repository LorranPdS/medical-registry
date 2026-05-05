package com.lorranpds.vitaflow.medical_registry.controllers;

import com.lorranpds.vitaflow.medical_registry.dto.NotificationCommand;
import com.lorranpds.vitaflow.medical_registry.dto.NotificationRequest;
import com.lorranpds.vitaflow.medical_registry.mappers.NotificationMapper;
import com.lorranpds.vitaflow.medical_registry.services.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationMapper notificationMapper;
    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Void> sendNotification(@RequestBody @Valid NotificationRequest request){
        NotificationCommand command = notificationMapper.toCommand(request);
        notificationService.execute(command);
        return ResponseEntity.accepted().build();
    }
}
