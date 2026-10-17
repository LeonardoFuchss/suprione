package com.leonardo.suprione.perfil;

import org.springframework.stereotype.Component;

@Component
public class PerfilMapper {

    public Perfil toEntity(PerfilRequest req) {
        return Perfil.builder()
                .nome(req.nome())
                .permissoes(req.permissoes())
                .build();
    }

    public PerfilResumoResponse toPerfilResumoDto(Perfil perfil) {
        return new PerfilResumoResponse(
                perfil.getNome(),
                perfil.isAtivo()
        );
    }

    public PerfilResponse toPerfilDto(Perfil perfil) {
        return new PerfilResponse(
                perfil.getNome(),
                perfil.isAtivo(),
                perfil.getPermissoes()
        );
    }
}
