package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.supplier.SupplierDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.supplier.SupplierMapper;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.supplier.SupplierRequest;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.supplier.SupplierResponse;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities.SupplierEntity;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service.fornecedor.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fornecedores")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;
    private final SupplierMapper supplierMapper;

    @PostMapping
    public ResponseEntity<SupplierResponse> criar(@RequestBody SupplierRequest supplierRequest) {

        // 1. Converter Request Web para Command Puro
        SupplierDTO supplierDTO = supplierMapper.toDTO(supplierRequest);

        // 2. Service executa o Template Method completo
        SupplierEntity fornecedorSalvo = supplierService.processarCriacao(supplierDTO);

        // 3. (Opcional, mas recomendado) Converter Entidade para Response
        SupplierResponse response = new SupplierResponse(fornecedorSalvo.getId(), fornecedorSalvo.getNome());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
