package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.PedidoRequest;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.service.PedidoServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoServiceInterface pedidoService;

    @PostMapping("/pagamento")
    public ResponseEntity<Void> pagar(@RequestBody @Valid PedidoRequest request){
//        PedidoDTO dto = mapper.toDTO(request); Nesse daqui como foi apenas o atributo do ID, não fiz a alteração, não sei se está certo
        pedidoService.realizarPagamento(request.idPedido());
//        return ResponseEntity.status(NO_CONTENT).build(); Essa linha e a de baixo é a mesma coisa
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/envio")
    public ResponseEntity<Void> enviar(@RequestBody @Valid PedidoRequest request){
//        PedidoDTO dto = mapper.toDTO(request); Nesse daqui como foi apenas o atributo do ID, não fiz a alteração, não sei se está certo
        pedidoService.enviarPedido(request.idPedido());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cancelamento")
    public ResponseEntity<Void> cancelar(@RequestBody @Valid PedidoRequest request){
//        PedidoDTO dto = mapper.toDTO(request); Nesse daqui como foi apenas o atributo do ID, não fiz a alteração, não sei se está certo
        pedidoService.cancelarPedido(request.idPedido());
        return ResponseEntity.noContent().build();
    }
}
