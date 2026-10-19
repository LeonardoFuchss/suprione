package com.leonardo.suprione.usuario;

import jakarta.validation.constraints.*;

public record UsuarioRequest(
        @NotBlank(message = "O campo 'nome' não pode ser nulo ou vazio.")
        @Size(min = 2, max = 100, message = "O campo 'nome' deve possuir entre 2 e 100 caracteres.")
        String nome,
        @NotBlank(message = "O campo 'email' não pode ser nulo ou vazio.")
        @Email(message = "O campo 'email' deve possuir um valor válido.")
        @Size(max = 254, message = "O campo 'email' não pode exceder 254 caracteres.")
        String email,
        @NotBlank(message = "O campo 'senha' não pode ser nulo ou vazio.")
        @Pattern(regexp = "^(?=.*\\p{Ll})(?=.*\\p{Lu})(?=.*\\p{N})(?=.*[^\\p{L}\\p{N}\\s]).+$", message = "A senha deve conter ao menos uma letra minúscula, uma maiúscula, um número e um caractere especial.")
        @Size(min = 12, max = 64, message = "A senha deve possuir entre 12 e 64 caracteres.")
        String senha,
        @NotNull(message = "O campo 'perfilId' é obrigatório.")
        @Positive(message = "O campo 'perfilId' deve ser maior que zero.")
        Long perfilId
) {
}
