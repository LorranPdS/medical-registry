package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelRequest;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMovelResponse;
import com.lorranpds.vitaflow.medical_registry.enums.EstiloMovelEnum;
import com.lorranpds.vitaflow.medical_registry.factories.MoveisFactory;
import com.lorranpds.vitaflow.medical_registry.services.PedidoMovelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoMovelServiceImpl implements PedidoMovelService {

    private final Map<EstiloMovelEnum, MoveisFactory> fabricaCache;

    public PedidoMovelServiceImpl(List<MoveisFactory> fabricasCache) {
        this.fabricaCache = fabricasCache.stream()
                .collect(Collectors.toUnmodifiableMap( // TODO: perguntar ao GEMINI: esse método ou o .toMap()?
                        MoveisFactory::getEstilo,
                        factory -> factory
                ));
    }

    @Override
    public PedidoMovelResponse montarConjuntoPorEstilo(PedidoMovelRequest pedidoMovelRequest) {
        MoveisFactory moveisFactory = fabricaCache.get(pedidoMovelRequest.getEstilo());
        return Optional.ofNullable(moveisFactory)
                .orElseThrow(() -> new IllegalArgumentException("Estilo de móvel não encontrado"))
                .montarConjunto();
    }
}
