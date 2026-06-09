package com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserEntity { // Usuário

    /* OBSERVAÇÃO
       Não coloquei as validações por annotations aqui só para trabalhar as
       validações no UserService mesmo pro padrão Template Method
    */
    private UUID id;
    private String nome;
    private Integer idade;
    private String email;
}
