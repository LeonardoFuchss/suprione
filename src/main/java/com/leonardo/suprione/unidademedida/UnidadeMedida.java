package com.leonardo.suprione.unidademedida;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnidadeMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean ativo;

    public void atualizarUnidadeMedida(UnidadeMedidaRequest req) {
        this.setNome(req.nome());
        this.setAtivo(req.ativo());
    }
}
