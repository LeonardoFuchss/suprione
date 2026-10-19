package com.leonardo.suprione.perfil;

import com.leonardo.suprione.usuario.Permissao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record PerfilRequest(
        @NotBlank(message = "O campo 'nome' não pode ser nulo ou vazio.")
        @Size(min = 2, max = 100, message = "O campo 'nome' deve possuir entre 2 e 100 caracteres.")
        String nome,
        @NotEmpty(message = "O perfil deve possuir ao menos uma permissão.")
        Set<@NotNull(message = "A permissão não pode ser nula.") Permissao> permissoes
) {
}
