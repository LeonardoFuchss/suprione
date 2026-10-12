package com.leonardo.suprione.usuario;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        Boolean ativo,
        String nomePerfil

) {
}
