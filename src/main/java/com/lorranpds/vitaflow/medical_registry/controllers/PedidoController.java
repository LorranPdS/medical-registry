package com.lorranpds.vitaflow.medical_registry.controllers;

import com.lorranpds.vitaflow.medical_registry.dtos.PedidoCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.PedidoRequest;
import com.lorranpds.vitaflow.medical_registry.dtos.PedidoResponse;
import com.lorranpds.vitaflow.medical_registry.mappers.PedidoMapper;
import com.lorranpds.vitaflow.medical_registry.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoMapper mapper;
    private final PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoResponse> registrarPedido(@RequestBody PedidoRequest request){
        PedidoCommand command = mapper.toCommand(request);
        PedidoResponse response = service.executar(command);
        return ResponseEntity.ok(response);
    }
}
