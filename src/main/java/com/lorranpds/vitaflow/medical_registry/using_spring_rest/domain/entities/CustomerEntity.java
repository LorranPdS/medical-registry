package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
public class CustomerEntity { // cliente

    /* OBSERVAÇÃO
       Não coloquei as validações por annotations aqui só para trabalhar as
       validações no CustomerService mesmo pro padrão Template Method
     */
    private UUID id;
    private String nome;
    private String endereco;
    private BigDecimal limiteCredito;
}
