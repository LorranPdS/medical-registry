package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dtos.UsuarioCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse executar(UsuarioCommand command);
}
