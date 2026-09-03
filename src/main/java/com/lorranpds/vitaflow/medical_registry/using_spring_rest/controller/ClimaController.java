package com.lorranpds.vitaflow.medical_registry.using_spring_rest.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.dto.ClimaDto;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.services.OpenWeatherPrevisaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 3. Cliente (Controller)
@RestController
@RequestMapping("api/v1/clima")
public class ClimaController{

    // O Spring injeta o Proxy gerado dinamicamente, não o PrevisaoTempoServiceImpl diretamente.
    private final OpenWeatherPrevisaoService climaService;

    public ClimaController(OpenWeatherPrevisaoService climaService){
        this.climaService = climaService;
    }

    @GetMapping("/{cidade}")
    public ClimaDto obterClima(@PathVariable String cidade){
        // Na 1ª vez, o Proxy repassa a chamada para o objeto real e guarda o resultado.
        // Na 2ª vez, o Proxy devolve o dado da memória, sem chamar a classe real.
        return climaService.buscarClima(cidade);
    }
}
