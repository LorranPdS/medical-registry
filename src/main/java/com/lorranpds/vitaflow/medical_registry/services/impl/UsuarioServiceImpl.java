package com.lorranpds.vitaflow.medical_registry.services.impl;

import com.lorranpds.vitaflow.medical_registry.builders.Usuario;
import com.lorranpds.vitaflow.medical_registry.dtos.UsuarioCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.UsuarioResponse;
import com.lorranpds.vitaflow.medical_registry.exceptions.BusinessException;
import com.lorranpds.vitaflow.medical_registry.services.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.lorranpds.vitaflow.medical_registry.builders.Usuario.builderPadraoBrasil;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final String LORRAN = "Lorran";

    @Override
    public UsuarioResponse executar(UsuarioCommand command) {
        Usuario usuarioTemplate = command.isBrasil() ? setTemplate(command) : setGeneral(command);

        System.out.println("Exemplo de Builder Template: " + usuarioTemplate);
        return new UsuarioResponse(usuarioTemplate.toString());
    }

    private Usuario setGeneral(UsuarioCommand command) {
        validarDadosPaisEstrangeiro(command);
        return new Usuario.Builder()
                .comNome(command.nome())
                .comPais(command.pais())
                .comIdioma(command.idioma())
                .isAtivo(command.ativo())
                .build();
    }

    private void validarDadosPaisEstrangeiro(UsuarioCommand command) {
        if(!StringUtils.hasText(command.pais()) || !StringUtils.hasText(command.idioma())){
            throw new BusinessException("O preenchimento dos campos 'pais' e 'idioma' são obrigatórios.");
        }
    }

    private Usuario setTemplate(UsuarioCommand command) {
        return builderPadraoBrasil().comNome(command.nome()).build();
    }
}
