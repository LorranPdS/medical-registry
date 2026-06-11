package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service.usuario;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.user.UserDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities.UserEntity;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure.AbstractEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

// Serviço Concreto (Ex: Criação de Usuário)
@Slf4j
@Service
public class UserService extends AbstractEntityService<UserDTO, UserEntity> {

    private static final Integer DEZOITO_ANOS = 18;

    @Override
    protected void validar(UserDTO dto){
        if (!StringUtils.hasText(dto.nome())) {
            throw new IllegalArgumentException("Obrigatório o preenchimento do nome");
        }

        if(dto.idade() < DEZOITO_ANOS){
            throw new IllegalArgumentException("Usuário precisa ter no mínimo 18 anos");
        }

        if(!StringUtils.hasText(dto.email())){
            throw new IllegalArgumentException("Obrigatório o preenchimento do email");
        }
        log.info("Usuário {} validado com sucesso", dto.nome());
    }

    @Override
    protected UserEntity converterParaEntidade(UserDTO dto) {
        // Aqui você faria a conversão manual ou usaria MapStruct/ModelMapper
        UserEntity usuario = new UserEntity();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setDataCriacao(LocalDateTime.now()); // Setando campos do sistema
        usuario.setStatusAtivo(true);
        return usuario;
    }

    @Override
    protected void enviarNotificacao(UserEntity usuario){
        log.info("Enviando e-mail de boas-vindas para {}", usuario.getEmail());
    }
}
