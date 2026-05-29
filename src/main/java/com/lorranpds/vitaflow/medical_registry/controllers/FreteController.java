package com.lorranpds.vitaflow.medical_registry.controllers;

import com.lorranpds.vitaflow.medical_registry.dtos.command.FreteCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.request.FreteRequest;
import com.lorranpds.vitaflow.medical_registry.dtos.response.FreteResponse;
import com.lorranpds.vitaflow.medical_registry.mappers.FreteMapper;
import com.lorranpds.vitaflow.medical_registry.services.CalculadoraFreteServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/fretes")
@RequiredArgsConstructor
public class FreteController {

    private final FreteMapper mapper;
    private final CalculadoraFreteServiceInterface service;

    @PostMapping("/simulacoes")
    public ResponseEntity<List<FreteResponse>> simularFretes(@RequestBody @Valid FreteRequest request){
        FreteCommand command = mapper.toCommand(request);
        List<FreteResponse> response = service.calcular(command);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
