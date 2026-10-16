package com.leonardo.suprione.usuario;

public record UsuarioRequest(
        String nome,
        String email,
        String senha,
        Long perfilId
) {
}
