package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.abstractfactories.MoveisFactory;
import com.lorranpds.vitaflow.medical_registry.dto.ConfiguracaoPedidoCommand;
import com.lorranpds.vitaflow.medical_registry.dto.PedidoMoveisResponse;
import com.lorranpds.vitaflow.medical_registry.enums.EstiloMoveis;
import com.lorranpds.vitaflow.medical_registry.services.Cadeira;
import com.lorranpds.vitaflow.medical_registry.services.PedidoMoveisService;
import com.lorranpds.vitaflow.medical_registry.services.Sofa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoMoveisServiceImpl implements PedidoMoveisService {

    private final Map<EstiloMoveis, MoveisFactory> fabricaCache;
//    private final PedidoMovelMapper pedidoMovelMapper; // O Mapper passará a ser útil quando eu tiver uma Entity (JPA/Hibernate), daí implemento

    public PedidoMoveisServiceImpl(List<MoveisFactory> fabricasCache/*, PedidoMoveisMapper pedidoMoveisMapper*/) {
//        this.pedidoMovelMapper = pedidoMovelMapper;
        this.fabricaCache = fabricasCache.stream()
                .collect(Collectors.toUnmodifiableMap(
                        MoveisFactory::getEstilo,
                        factory -> factory
                ));
    }

    @Override
    public PedidoMoveisResponse montarConjuntoPorEstilo(ConfiguracaoPedidoCommand command) { // TODO: aplicar o record da penúltima pergunta
        MoveisFactory moveisFactory = fabricaCache.get(command.estilo());
        Optional.ofNullable(moveisFactory).orElseThrow(() -> new IllegalArgumentException("Estilo de móvel não encontrado"));

        // Criamos uma vez
        Cadeira cadeira = moveisFactory.criarCadeira();
        Sofa sofa = moveisFactory.criarSofa();

        // Executamos as ações de cada um deles
        cadeira.sentar();
        sofa.deitar();

        // TODO: Aqui o Mapper seria perfeito no futuro!
        return new PedidoMoveisResponse(moveisFactory.getEstilo(), cadeira, sofa);
    }
}
