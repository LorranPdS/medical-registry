package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.UsuarioDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.UsuarioMapper;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.UsuarioRequest;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("api/v1/usuarios")
@RestController
public class UsuarioController {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioService usuarioService; // Injeta o Service aqui

    @PostMapping("/validar")
    public ResponseEntity<Void> validarUsuario(@RequestBody @Valid UsuarioRequest request){
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(request);

        // Aciona o serviço que vai rodar toda a cadeia de responsabilidade
        usuarioService.cadastrar(usuarioDTO);
        return ResponseEntity.accepted().build();
    }
}
