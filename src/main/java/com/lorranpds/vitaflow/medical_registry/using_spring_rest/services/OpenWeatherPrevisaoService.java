package com.lorranpds.vitaflow.medical_registry.using_spring_rest.services;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.dto.ClimaResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

// Essa implementação está usando a API OpenWeather

// 2. Real Subject
@Service
public class OpenWeatherPrevisaoService {

    // O Spring cria um Proxy ao redor deste metodo graças à anotação @Cacheable!
    @Cacheable(key = "#cidade", value = "climaCache")
    public ClimaResponse buscarClima(String cidade){
        System.out.println(">> Chamando API externa cara da OPEN WEATHER para o clima em: " + cidade);
        // Simulação de delay de rede
        simularAtraso();

        return new ClimaResponse(cidade, 25.5, "Ensolarado"); // Resposta da API Open Weather
    }

    private void simularAtraso(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
