package com.lorranpds.vitaflow.medical_registry.using_spring_rest.dto;

import java.util.UUID;

// DTO de Saída limpo enviado ao Frontend
public record ArtigoResponse(UUID id, String titulo, String texto) {}