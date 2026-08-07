package com.lorranpds.vitaflow.medical_registry.using_spring_rest.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.Medico;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.dtos.MedicoResponseDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.service.ConsultaMedicoService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/medicos")
@Validated // Habilita a validação para parâmetros de métodos (@PathVariable, @RequestParam)
public class MedicoController {

    private final ConsultaMedicoService consultaMedicoService;

    public MedicoController(ConsultaMedicoService consultaMedicoService) {
        this.consultaMedicoService = consultaMedicoService;
    }

    @GetMapping("/{crm}")
    public ResponseEntity<MedicoResponseDTO> consultarPorCrm(
            @PathVariable
            @NotBlank(message = "O CRM não pode ser vazio")
            @Pattern(regexp = "\\d{4,6}-[A-Z]{2}", message = "O CRM deve seguir o formato 123456-UF (ex: 123456-SC)")
            String crm) {

        // 1. O Controller recebe a requisição validada e repassa para o Service
        Medico medico = consultaMedicoService.consultaAndValidaSituacao(crm);

        // 2. Mapeia o resultado de domínio para o DTO de Response HTTP
        MedicoResponseDTO response = MedicoResponseDTO.fromDomain(medico);

        return ResponseEntity.ok(response);
    }
}
