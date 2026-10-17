package com.leonardo.suprione.perfil;

import com.leonardo.suprione.usuario.Permissao;

import java.util.Set;

public record AtualizarPerfilRequest(
        String nome,
        Set<Permissao> permissoes
) {
}
