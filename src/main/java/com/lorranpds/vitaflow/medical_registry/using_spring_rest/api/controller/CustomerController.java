package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.customer.CustomerDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.customer.CustomerMapper;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.customer.CustomerRequest;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.customer.CustomerResponse;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities.CustomerEntity;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service.cliente.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<CustomerResponse> criar(@RequestBody CustomerRequest customerRequest) {

        // 1. Converter Request Web para Command Puro
        CustomerDTO customerDTO = customerMapper.toDTO(customerRequest);

        // 2. Service executa o Template Method completo
        CustomerEntity clienteSalvo = customerService.processarCriacao(customerDTO);

        // 3. (Opcional, mas recomendado) Converter Entidade para Response
        CustomerResponse response = new CustomerResponse(clienteSalvo.getId(), clienteSalvo.getNome());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
