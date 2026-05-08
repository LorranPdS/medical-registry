package com.lorranpds.vitaflow.medical_registry.controllers;

import com.lorranpds.vitaflow.medical_registry.dtos.UsuarioCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.UsuarioRequest;
import com.lorranpds.vitaflow.medical_registry.dtos.UsuarioResponse;
import com.lorranpds.vitaflow.medical_registry.mappers.UsuarioMapper;
import com.lorranpds.vitaflow.medical_registry.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioMapper mapper;
    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody @Valid UsuarioRequest request){
        UsuarioCommand command = mapper.toCommand(request);
        UsuarioResponse response = service.executar(command);
        return ResponseEntity.ok(response);
    }
}
