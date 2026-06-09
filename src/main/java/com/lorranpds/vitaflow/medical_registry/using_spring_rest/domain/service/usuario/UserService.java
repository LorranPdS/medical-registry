package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service.usuario;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities.UserEntity;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.AbstractEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

// Serviço Concreto (Ex: Criação de Usuário)
@Slf4j
@Service
public class UserService extends AbstractEntityService<UserEntity> {

    private static final Integer DEZOITO_ANOS = 18;

    @Override
    protected void validar(UserEntity usuario){
        if (StringUtils.hasText(usuario.getNome())) {
            throw new IllegalArgumentException("Obrigatório o preenchimento do nome");
        }

        if(usuario.getIdade() > DEZOITO_ANOS){
            throw new IllegalArgumentException("Usuário precisa ter no mínimo 18 anos");
        }

        if(StringUtils.hasText(usuario.getEmail())){
            throw new IllegalArgumentException("Obrigatório o preenchimento do email");
        }
        log.info("Usuário {} validado com sucesso.", usuario.getNome());
    }

    @Override
    protected void enviarNotificacao(UserEntity usuario){
        log.info("Enviando e-mail de boas-vindas para {}", usuario.getEmail());
    }
}
