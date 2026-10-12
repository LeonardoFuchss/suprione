package com.leonardo.suprione.usuario;

import com.leonardo.suprione.usuario.perfil.Perfil;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequest req, Perfil perfil) {

        return Usuario.builder()
                .nome(req.nome())
                .email(req.email())
                .senha(req.senha())
                .perfil(perfil)
                .build();
    }

    public UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.isAtivo(),
                usuario.getPerfil().getNome());
    }
}
