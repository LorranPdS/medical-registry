package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class SupplierEntity {

    private UUID id;
    private String nome;
    private String endereco;
    private Integer limiteDiasParaRecebimento;
}
