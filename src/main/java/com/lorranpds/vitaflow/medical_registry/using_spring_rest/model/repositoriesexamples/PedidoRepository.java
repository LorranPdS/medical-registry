package com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.repositoriesexamples;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.model.entitiesexample.PedidoEntity;

import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository {

    // Em um sistema real, seria usado o JPA. Isso daqui foi só um exemplo fake
    Optional<PedidoEntity> findById(UUID idPedido);

    void save(PedidoEntity pedidoEntity);
}
