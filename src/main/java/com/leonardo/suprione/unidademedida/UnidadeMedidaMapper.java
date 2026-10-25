package com.leonardo.suprione.unidademedida;

import org.springframework.stereotype.Component;

@Component
public class UnidadeMedidaMapper {

    public UnidadeMedida toEntity(UnidadeMedidaRequest req) {
        return UnidadeMedida.builder()
                .nome(req.nome())
                .ativo(req.ativo())
                .build();
    }
    public UnidadeMedidaResponse toUnidadeMedidaResponse(UnidadeMedida unidadeMedida){
        return new UnidadeMedidaResponse(
                unidadeMedida.getNome(),
                unidadeMedida.isAtivo()
        );
    }
}
