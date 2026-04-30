package com.lorranpds.vitaflow.medical_registry.controllers;

import com.lorranpds.vitaflow.medical_registry.dtos.NotificationRequest;
import com.lorranpds.vitaflow.medical_registry.services.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notifications")
@RequiredArgsConstructor
public class NotificationController {

	private final NotificationService notificationService;

	@PostMapping
	public ResponseEntity<Void> sendNotification(@RequestBody @Valid NotificationRequest request) {
		notificationService.execute(request);
		return ResponseEntity.accepted().build();
	}

}
