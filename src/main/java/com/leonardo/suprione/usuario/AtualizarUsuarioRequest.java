package com.leonardo.suprione.usuario;

import jakarta.validation.constraints.*;

public record AtualizarUsuarioRequest(
        @NotBlank(message = "O campo 'nome' não pode ser nulo ou vazio.")
        @Size(min = 2, max = 100, message = "O campo 'nome' deve possuir entre 2 e 100 caracteres.")
        String nome,
        @NotBlank(message = "O campo 'email' não pode ser nulo ou vazio.")
        @Email(message = "O campo 'email' deve possuir um valor válido.")
        @Size(max = 254, message = "O campo 'email' não pode exceder 254 caracteres.")
        String email,
        @NotNull(message = "O campo 'perfilId' é obrigatório.")
        @Positive(message = "O campo 'perfilId' deve ser maior que zero.")
        Long perfilId
) {
}
