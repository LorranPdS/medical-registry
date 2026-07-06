package com.lorranpds.vitaflow.medical_registry.using_spring_rest.dto;

// DTO de Saída limpo enviado ao Frontend
public record ArtigoResponse(Long id, String titulo, String texto) {}