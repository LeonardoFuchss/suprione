package com.leonardo.suprione.usuario;

import com.leonardo.suprione.usuario.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private boolean ativo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfilId")
    private Perfil perfil;

    public void atualizarUsuario(AtualizarUsuarioRequest req, Perfil perfil) {
        this.setNome(req.nome());
        this.setEmail(req.email());
        this.setPerfil(perfil);
    }
}
