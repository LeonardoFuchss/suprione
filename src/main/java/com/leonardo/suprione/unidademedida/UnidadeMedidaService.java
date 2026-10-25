package com.leonardo.suprione.unidademedida;

import java.util.List;


public interface UnidadeMedidaService {
    UnidadeMedidaResponse criarUnidadeMedida(UnidadeMedidaRequest req);
    List<UnidadeMedidaResponse> buscarUnidadeMedidas();
    UnidadeMedidaResponse buscarDetalhesUnidadeMedida(Long id);
    void atualizarUnidadeMedida(UnidadeMedidaRequest req, Long id);
    void desativarUnidadeMedida(Long id);
}
