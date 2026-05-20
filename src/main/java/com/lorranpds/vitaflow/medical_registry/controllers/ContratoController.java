package com.lorranpds.vitaflow.medical_registry.controllers;

import com.lorranpds.vitaflow.medical_registry.dtos.commands.ContratoCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.requests.ContratoRequestDTO;
import com.lorranpds.vitaflow.medical_registry.dtos.responses.ContratoTrabalhoResponseDTO;
import com.lorranpds.vitaflow.medical_registry.mappers.ContratoMapper;
import com.lorranpds.vitaflow.medical_registry.services.ContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contratos")
@RequiredArgsConstructor
public class ContratoController {

    private final ContratoService contratoService;
    private final ContratoMapper contratoMapper;

    @PostMapping
    public ResponseEntity<ContratoTrabalhoResponseDTO> criarContrato(@RequestBody ContratoRequestDTO request) {

        ContratoCommand contratoCommand = contratoMapper.toCommand(request);
        ContratoTrabalhoResponseDTO contratoGeradoResponse = contratoService.gerarNovoContrato(contratoCommand);

        // O Spring converterá o objeto 'ContratoTrabalhoResponseDTO' em JSON para a resposta graças aos @Getters
        return ResponseEntity.status(HttpStatus.CREATED).body(contratoGeradoResponse);
    }
}
