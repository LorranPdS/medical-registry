package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.UsuarioDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(2)
@Component
class ValidacaoIdade implements ValidacaoUsuario{
    @Override
    public void validar(UsuarioDTO usuarioDTO){
        if (usuarioDTO.idade() < 18) {
            throw new RuntimeException("Usuário deve ser maior de idade!");
        }
        log.info("### Idade validada. TUDO OK ###");
    }
}
