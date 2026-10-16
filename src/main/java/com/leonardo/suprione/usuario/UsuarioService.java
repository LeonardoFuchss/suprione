package com.leonardo.suprione.usuario;

import java.util.List;

public interface UsuarioService {
    UsuarioResponse criarUsuario(UsuarioRequest req);
    List<UsuarioResponse> buscarUsuarios();
    UsuarioResponse buscarUsuarioPeloId(Long id);
    void atualizarUsuario(AtualizarUsuarioRequest req, Long id);
    void desativarUsuarioPeloId(Long id);
}
