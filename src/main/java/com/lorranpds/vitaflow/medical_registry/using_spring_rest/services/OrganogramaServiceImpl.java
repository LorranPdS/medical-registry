package com.lorranpds.vitaflow.medical_registry.using_spring_rest.services;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.MembroEquipe;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.dtos.OrganogramaResponseDTO;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.repositories.OrganogramaRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrganogramaServiceImpl implements OrganogramaService{

    private final OrganogramaRepository organogramaRepository;

    // Injeção de dependência via construtor
    public OrganogramaServiceImpl(OrganogramaRepository organogramaRepository){
        this.organogramaRepository = organogramaRepository;
    }

    @Override
    public OrganogramaResponseDTO consultarRelatorioPorDepartamento(String codigoDepartamento){
        // 1. Busca a árvore na base de dados
        MembroEquipe raizDepartamento = organogramaRepository
                .buscarPorCodigoDepartamento(codigoDepartamento)
                .orElseThrow(() -> new NoSuchElementException("Departamento não encontrado: " + codigoDepartamento));

        // 2. Executa as regras de agregação polimórficas do Composite
        return new OrganogramaResponseDTO(
                codigoDepartamento.toUpperCase(),
                raizDepartamento.nome(),
                raizDepartamento.cargo(),
                raizDepartamento.salario(),                 // Polimorfismo recursivo da folha de pagamento
                raizDepartamento.quantidadeSubordinados()   // Polimorfismo recursivo da contagem da equipe
        );
    }
}
