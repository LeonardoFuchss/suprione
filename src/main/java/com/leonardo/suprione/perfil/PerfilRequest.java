package com.leonardo.suprione.perfil;

import com.leonardo.suprione.usuario.Permissao;
import java.util.Set;

public record PerfilRequest(
        String nome,
        Set<Permissao> permissoes
) {
}
