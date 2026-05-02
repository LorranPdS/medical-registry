package com.lorranpds.vitaflow.medical_registry.controller;

import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelRequest;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelResponse;
import com.lorranpds.vitaflow.medical_registry.services.PedidoMovelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pedidomoveis")
public class PedidoMovelController {

    private final PedidoMovelService pedidoMovelService;

    public PedidoMovelController(PedidoMovelService pedidoMovelService){
        this.pedidoMovelService = pedidoMovelService;
    }

    /*
        PERGUNTAR AO GEMINI:
        1) O que seria uma melhor prática abaixo: passar para o Service o Request inteiro mesmo tendo
         um único atributo ou seria melhor mesmo setar o único atributo de uma vez? Inicialmente, acredito
         que, mesmo tendo um único atributo e colocar o request completo, caso precisar incluir algum outro
         atributo no request futuramente, não vou precisar mexer nem no Controller nem nessa interface do
         Service, PORÉM não sei se fazer desse jeito de passar apenas o parâmetro há ganho de performance
     */
    @PostMapping
    public ResponseEntity<PedidoMovelResponse> criarConjunto(@RequestBody PedidoMovelRequest pedidoMovelRequest){
        PedidoMovelResponse pedidoMovelResponse = pedidoMovelService.montarConjuntoPorEstilo(pedidoMovelRequest);
        return ResponseEntity.ok(pedidoMovelResponse);
    }
}
