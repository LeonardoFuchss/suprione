package com.leonardo.suprione.perfil;

import com.leonardo.suprione.usuario.Permissao;

import java.util.Set;

public record PerfilResponse(
        String nome,
        boolean ativo,
        Set<Permissao> permissoes
) {
}
