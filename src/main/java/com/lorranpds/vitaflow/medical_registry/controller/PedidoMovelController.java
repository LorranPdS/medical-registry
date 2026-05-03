package com.lorranpds.vitaflow.medical_registry.controller;

import com.lorranpds.vitaflow.medical_registry.dto.ConfiguracaoPedidoCommand;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelRequest;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelResponse;
import com.lorranpds.vitaflow.medical_registry.mappers.PedidoMovelMapper;
import com.lorranpds.vitaflow.medical_registry.services.PedidoMovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedidomoveis")
@RequiredArgsConstructor
public class PedidoMovelController {

    private final PedidoMovelService pedidoMovelService;
    private final PedidoMovelMapper pedidoMovelMapper;

    @PostMapping
    public ResponseEntity<PedidoMovelResponse> criarConjunto(@RequestBody PedidoMovelRequest pedidoMovelRequest){
        // O Mapper converte o DTO da Web para um "Objeto de Comando" do Service. Isso evita que o Service conheça o PedidoMovelRequest
        ConfiguracaoPedidoCommand comando = pedidoMovelMapper.toCommand(pedidoMovelRequest);

        PedidoMovelResponse pedidoMovelResponse = pedidoMovelService.montarConjuntoPorEstilo(comando);
        return ResponseEntity.ok(pedidoMovelResponse);
    }
}
