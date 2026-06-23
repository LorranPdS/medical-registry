package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.UsuarioDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 2. Handlers Concretos
@Slf4j
@Order(1) // Define a ordem na cadeia
@Component
class ValidacaoEmail implements ValidacaoUsuario{

    @Override
    public void validar(UsuarioDTO usuarioDTO){
        if (!usuarioDTO.email().contains("@")) {
            throw new RuntimeException("E-mail inválido!"); // Interrompe a cadeia
        }
        log.info("### E-mail validado. TUDO OK ###");
    }
}
