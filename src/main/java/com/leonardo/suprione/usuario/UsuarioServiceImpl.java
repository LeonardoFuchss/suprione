package com.leonardo.suprione.usuario;

import com.leonardo.suprione.perfil.Perfil;
import com.leonardo.suprione.perfil.PerfilRepository;
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
        Perfil perfilEncontrado = perfilRepository.findById(req.perfilId()).orElseThrow(() -> new RuntimeException("Perfil não encontrado."));
        Usuario usuario = mapper.toEntity(req, perfilEncontrado);
        usuario.setAtivo(true);
        if (repository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Já existe um usuário para o e-mail informado.");
        }
        Usuario usuarioCriado = repository.save(usuario);
        return mapper.toResponse(usuarioCriado);
    }
    @Override
    public List<UsuarioResponse> buscarUsuarios() {
        List<Usuario> usuarios = repository.findAll();
        return usuarios.stream()
                .map(mapper::toResponse).toList();

    }
    @Override
    public UsuarioResponse buscarUsuarioPeloId(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return mapper.toResponse(usuario);
    }

    @Override
    public void atualizarUsuario(AtualizarUsuarioRequest req, Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        Perfil perfil = perfilRepository.findById(usuario.getPerfil().getId()).orElseThrow(() -> new RuntimeException("Perfil não encontrado."));
        usuario.atualizarUsuario(req, perfil);
    }
    @Override
    @Transactional
    public void desativarUsuarioPeloId(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        usuario.setAtivo(false);
    }
}
