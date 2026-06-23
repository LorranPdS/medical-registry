package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.UsuarioDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.ValidacaoUsuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

// 3. O "Motor" da Cadeia no Service
@Slf4j
@Service
public class UsuarioService{

    // O Spring injeta automaticamente todos os beans que implementam
    // a interface na ordem especificada pelo @Order!
    private final List<ValidacaoUsuario> validacoes;

    public UsuarioService(List<ValidacaoUsuario> validacoes){
        this.validacoes = validacoes;
    }

    public void cadastrar(UsuarioDTO usuarioDTO){
        // Percorre a cadeia de responsabilidade
        for (ValidacaoUsuario validacao : validacoes) {
            validacao.validar(usuarioDTO);
        }
//        validacoes.forEach(validacao -> validacao.validar(usuarioDTO)); // Outra forma de fazer a iteração acima

        log.info("Cadeia de validações finalizada com sucesso");
        log.info("Simulando alguma outra rotina para salvar Usuario [{}] na base de dados...", usuarioDTO.nome());
    }
}
