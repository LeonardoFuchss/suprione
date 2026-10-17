package com.leonardo.suprione.perfil;

import java.util.List;

public interface PerfilService {
    PerfilResponse criarPerfil(PerfilRequest req);
    List<PerfilResumoResponse> buscarResumoPerfis();
    PerfilResponse buscarDetalhesPerfil(Long id);
    void atualizarPerfil(AtualizarPerfilRequest req, Long id);
    void desativarPerfil(Long id);
}
