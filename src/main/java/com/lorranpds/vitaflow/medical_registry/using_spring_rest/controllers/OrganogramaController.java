package com.lorranpds.vitaflow.medical_registry.using_spring_rest.controllers;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.dtos.OrganogramaResponseDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.services.OrganogramaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organogramas") // Nome do recurso no plural (Padrão REST)
public class OrganogramaController{

    private final OrganogramaService organogramaService;

    public OrganogramaController(OrganogramaService organogramaService){
        this.organogramaService = organogramaService;
    }

    /**
     * Endpoint dinâmico e agnóstico:
     * Exemplo: GET /api/v1/organogramas/DEP-ENG
     * Exemplo: GET /api/v1/organogramas/DEP-VENDAS
     */
    @GetMapping("/{codigoDepartamento}")
    public ResponseEntity<OrganogramaResponseDTO> consultarPorDepartamento(
            @PathVariable String codigoDepartamento){

        OrganogramaResponseDTO relatorio = organogramaService
                .consultarRelatorioPorDepartamento(codigoDepartamento);

        return ResponseEntity.ok(relatorio);
    }
}
