package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.UsuarioRequest;

// 1. A Interface (Handler)
public interface ValidacaoUsuario{
    void validar(UsuarioRequest request);
}