package com.lorranpds.vitaflow.medical_registry.using_spring_rest.infrastructure;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.Medico;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/*
    4. Adapter (Implementação)
        Essa será uma classe Spring que esconde a bagunça da chamada HTTP.
        Esta classe faz o papel de "tradutora". Ela consulta a API externa via RestClient
            (ou RestTemplate) e traduz a resposta para a nossa entidade/DTO de domínio.
 */
@Component
public class GovernoMedicoAdapter implements MedicoConselhoGateway {

    private final RestClient restClient;

    // Boa prática moderna no Spring: RestClient imutável injetado via construtor
    public GovernoMedicoAdapter(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://api.governo.gov/medicos/")
                .build();
    }

    @Override
    public Medico buscarPorCrm(String crm) {
        // 1. Faz a chamada remota usando o DTO da API do Governo
        GovernoMedicoResponseDTO response = restClient.get()
                .uri("/{crm}", crm)
                .retrieve()
                .body(GovernoMedicoResponseDTO.class);

        if (response == null) {
            throw new RuntimeException("Médico não encontrado no conselho regional");
        }

        // 2. ADAPTAÇÃO: Converte a resposta externa para o nosso modelo de domínio
        boolean isAtivo = "REGULAR".equalsIgnoreCase(response.situacaoRegularizacao());

        return new Medico(
                response.idConselho(),
                response.nomeCompleto(),
                isAtivo
        );
    }
}
