package com.lorranpds.vitaflow.medical_registry.services;

import com.lorranpds.vitaflow.medical_registry.dtos.commands.ContratoCommand;
import com.lorranpds.vitaflow.medical_registry.dtos.responses.ContratoTrabalhoResponseDTO;
import com.lorranpds.vitaflow.medical_registry.domain.ContratoTrabalho;
import com.lorranpds.vitaflow.medical_registry.infrastructure.ContratoPrototypeRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor // O Lombok cria o construtor injetando o Registry
public class ContratoServiceDefault implements ContratoService {

    private final ContratoPrototypeRegistry prototypeRegistry;

    @Override
    public ContratoTrabalhoResponseDTO gerarNovoContrato(ContratoCommand command) {

        // 1. Busca o molde base já carregado na memória (O(1) - Super rápido)
        ContratoTrabalho prototipoBase = prototypeRegistry.obterPrototipo(command.cargo());

        // 2. Cria o Clone (Cópia profunda das regras do sindicato)
        ContratoTrabalho novoContrato = prototipoBase.clonar();

        // 3. Customiza o clone com os dados mutáveis que vieram na requisição
        novoContrato.setNomeFuncionario(command.nomeFuncionario());

        // O hasText já faz a checagem de nulo, de vazio ("") e de espaços em branco ("   ")
        if (StringUtils.hasText(command.clausulaExtra())) {
            novoContrato.getRegrasSindicato().adicionarClausulaEspecifica(command.clausulaExtra());
        }

        // Simulação de salvar no banco e retornar
        // contratoRepository.save(novoContrato);

        return new ContratoTrabalhoResponseDTO(novoContrato.getCargo(), novoContrato.getRegrasSindicato(), novoContrato.getNomeFuncionario());
    }
}
