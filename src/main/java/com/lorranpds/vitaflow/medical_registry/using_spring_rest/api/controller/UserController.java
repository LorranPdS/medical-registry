package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.user.UserDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.user.UserMapper;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.user.UserRequest;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.user.UserResponse;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities.UserEntity;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service.usuario.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService usuarioService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponse> criar(@RequestBody UserRequest userRequest) {

        // 1. Converter Request Web para Command Puro
        UserDTO userDTO = userMapper.toDTO(userRequest);

        // 2. Service executa o Template Method completo
        UserEntity usuarioSalvo = usuarioService.processarCriacao(userDTO);

        // 3. (Opcional, mas recomendado) Converter Entidade para Response
        UserResponse response = new UserResponse(usuarioSalvo.getId(), usuarioSalvo.getNome());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}