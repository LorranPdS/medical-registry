package com.lorranpds.vitaflow.medical_registry.using_spring_rest.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.dto.ArtigoRequest;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.dto.ArtigoResponse;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.service.ArtigoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/artigos")
public class ArtigoController {

    private final ArtigoService artigoService;

    // Injeção de dependência via Construtor (Padrão Sênior)
    public ArtigoController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtigoResponse> atualizar(@PathVariable UUID id, @Valid @RequestBody ArtigoRequest request) {
        ArtigoResponse response = artigoService.atualizarArtigo(id, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/desfazer")
    public ResponseEntity<ArtigoResponse> desfazer(@PathVariable UUID id) {
        ArtigoResponse response = artigoService.desfazerUltimaAlteracao(id);
        return ResponseEntity.ok(response);
    }
}
