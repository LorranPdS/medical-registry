package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.customer;

import java.math.BigDecimal;

public record CustomerDTO(String nome, String endereco, BigDecimal limiteCredito) {
}