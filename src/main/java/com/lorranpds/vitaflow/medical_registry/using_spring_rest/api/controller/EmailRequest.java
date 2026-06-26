package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmailRequest(
        @NotBlank(message = "O destinatário é obrigatório.")
        @Email(message = "O formato do e-mail do destinatário é inválido.")
        String to,

        @NotBlank(message = "O conteúdo da mensagem não pode estar vazio.")
        @Size(max = 1000, message = "A mensagem não pode passar de {max} caracteres.")
        String msg
){}
