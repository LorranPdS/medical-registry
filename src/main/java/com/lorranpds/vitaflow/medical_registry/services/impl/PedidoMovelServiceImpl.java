package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.dto.ConfiguracaoPedidoCommand;
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
//    private final PedidoMovelMapper pedidoMovelMapper; // O Mapper passará a ser útil quando eu tiver uma Entity (JPA/Hibernate), daí implemento

    public PedidoMovelServiceImpl(List<MoveisFactory> fabricasCache/*, PedidoMovelMapper pedidoMovelMapper*/) {
//        this.pedidoMovelMapper = pedidoMovelMapper;
        this.fabricaCache = fabricasCache.stream()
                .collect(Collectors.toUnmodifiableMap(
                        MoveisFactory::getEstilo,
                        factory -> factory
                ));
    }

    @Override
    public PedidoMovelResponse montarConjuntoPorEstilo(ConfiguracaoPedidoCommand configuracaoPedidoRecord) { // TODO: aplicar o record da penúltima pergunta
        MoveisFactory moveisFactory = fabricaCache.get(configuracaoPedidoRecord.estilo());

        return Optional.ofNullable(moveisFactory)
                .orElseThrow(() -> new IllegalArgumentException("Estilo de móvel não encontrado"))
                .montarConjunto();
    }
}
