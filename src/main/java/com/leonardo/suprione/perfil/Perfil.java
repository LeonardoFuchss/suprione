package com.leonardo.suprione.perfil;

import com.leonardo.suprione.usuario.Permissao;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "perfil_permissao", joinColumns = @JoinColumn(name = "perfilId"))
    @Enumerated(EnumType.STRING)
    @Column(name = "permissao")
    private Set<Permissao> permissoes = new HashSet<>();
    private boolean ativo;

    public void atualizarPerfil(AtualizarPerfilRequest req) {
        this.setNome(req.nome());
        this.setPermissoes(req.permissoes());
    }
}
