package com.lorranpds.vitaflow.medical_registry.controller;

import com.lorranpds.vitaflow.medical_registry.dto.ConfiguracaoPedidoDTO;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMoveisRequest;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMoveisResponse;
import com.lorranpds.vitaflow.medical_registry.mappers.PedidoMoveisMapper;
import com.lorranpds.vitaflow.medical_registry.services.PedidoMoveisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedidomoveis")
@RequiredArgsConstructor
public class PedidoMoveisController {

    private final PedidoMoveisService pedidoMoveisService;
    private final PedidoMoveisMapper pedidoMoveisMapper;

    @PostMapping
    public ResponseEntity<PedidoMoveisResponse> criarConjunto(@RequestBody @Valid PedidoMoveisRequest pedidoMoveisRequest){
        // O Mapper converte o DTO da Web para um "Data Transfer Object (DTO)" do Service. Isso evita que o Service conheça o PedidoMovelRequest
        ConfiguracaoPedidoDTO configuracaoPedidoDTO = pedidoMoveisMapper.toDTO(pedidoMoveisRequest);

        PedidoMoveisResponse response = pedidoMoveisService.montarConjuntoPorEstilo(configuracaoPedidoDTO);
        return ResponseEntity.ok(response);
    }
}
