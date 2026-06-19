package com.lorranpds.vitaflow.medical_registry.client;

import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.handlers.Aprovador;
import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.handlers.CEO;
import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.handlers.Diretor;
import com.lorranpds.vitaflow.medical_registry.here_without_rest_architecture.handlers.Gerente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

// Há duas formas de criar esse T.U. Essa é uma forma mas tem uma outra forma legal lá no Notion também

// 3. Client
@ExtendWith(MockitoExtension.class)
public class SistemaAprovacaoTest {

    private Aprovador gerente;
    private Aprovador diretor;
    private Aprovador ceo;

    @BeforeEach
    void setUp(){
        // 1. Instanciamos as classes reais envolvidas num "Spy" do Mockito
        // O Spy permite executar a lógica real (os 'ifs'), mas rastreia as chamadas.
        gerente = spy(new Gerente());
        diretor = spy(new Diretor());
        ceo = spy(new CEO());

        // 2. Montamos a cadeia de responsabilidade para os testes
        gerente.setProximo(diretor);
        diretor.setProximo(ceo);
    }

    @Test
    void deveSerAprovadoPeloGerenteEPararACadeia(){
        // Act: Enviamos uma requisição de 500 (dentro do limite do gerente)
        gerente.processarRequisicao(BigDecimal.valueOf(500));

        // Assert:
        // Verificamos que o gerente processou a requisição 1 vez
        verify(gerente, times(1)).processarRequisicao(BigDecimal.valueOf(500));

        // Verificamos que a requisição NUNCA chegou ao diretor (a cadeia parou)
        verify(diretor, never()).processarRequisicao(BigDecimal.valueOf(ArgumentMatchers.anyDouble()));
        verify(ceo, never()).processarRequisicao(BigDecimal.valueOf(ArgumentMatchers.anyDouble()));
    }

    @Test
    void deveSerAprovadoPeloDiretorQuandoGerenteNaoPuder(){
        // Act: Enviamos uma requisição de 3000 (acima do gerente, limite do diretor)
        gerente.processarRequisicao(BigDecimal.valueOf(3000));

        // Assert:
        // O gerente tentou processar, mas passou para a frente
        verify(gerente, times(1)).processarRequisicao(BigDecimal.valueOf(3000));

        // O diretor recebeu a requisição e resolveu o problema
        verify(diretor, times(1)).processarRequisicao(BigDecimal.valueOf(3000));

        // O CEO nunca foi incomodado
        verify(ceo, never()).processarRequisicao(BigDecimal.valueOf(ArgumentMatchers.anyDouble()));
    }

    @Test
    void deveChegarAoCeoQuandoNenhumAnteriorAprovar(){
        // Act: Enviamos uma requisição de 15000
        gerente.processarRequisicao(BigDecimal.valueOf(15000));

        // Assert:
        // A requisição teve de passar por toda a cadeia
        verify(gerente, times(1)).processarRequisicao(BigDecimal.valueOf(15000));
        verify(diretor, times(1)).processarRequisicao(BigDecimal.valueOf(15000));
        verify(ceo, times(1)).processarRequisicao(BigDecimal.valueOf(15000));
    }
}
