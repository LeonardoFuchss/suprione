package com.leonardo.suprione.usuario;

public record AtualizarUsuarioRequest(
        String nome,
        String email,
        Long perfilId
) {
}
