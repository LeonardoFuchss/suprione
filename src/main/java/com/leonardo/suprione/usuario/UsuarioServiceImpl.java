package com.leonardo.suprione.usuario;

import com.leonardo.suprione.usuario.perfil.Perfil;
import com.leonardo.suprione.usuario.perfil.PerfilRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PerfilRepository perfilRepository;

    @Override
    @Transactional
    public UsuarioResponse criarUsuario(UsuarioRequest req) {
        Optional<Perfil> perfilEncontrado = Optional.of(perfilRepository.findById(req.perfil_id()).orElseThrow(() -> new RuntimeException("Perfil não encontrado.")));
        Usuario usuario = mapper.toEntity(req, perfilEncontrado.get());
        Optional<Usuario> usuarioEncontrado = Optional.of(repository.existsByEmail(usuario.getEmail()).orElseThrow(() -> new RuntimeException("Já existe um usuário para o e-mail informado.")));
        Usuario usuarioCriado = repository.save(usuarioEncontrado.get());
        return mapper.toResponse(usuarioCriado);
    }

    @Override
    public List<UsuarioResponse> buscarUsuarios() {
        return List.of();
    }

    @Override
    public UsuarioResponse buscarUsuarioPeloId(Long id) {
        return null;
    }

    @Override
    public void atualizarUsuario(UsuarioRequest req, Long id) {

    }

    @Override
    public void desativarUsuarioPeloId(Long id) {

    }
}
