package com.leonardo.suprione.perfil;

import com.leonardo.suprione.exception.BusinessException;
import com.leonardo.suprione.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PerfilServiceImpl implements PerfilService{
    private final PerfilRepository repository;
    private final PerfilMapper mapper;

    @Override
    @Transactional
    public PerfilResponse criarPerfil(PerfilRequest req) {
        boolean perfilExiste = repository.existsByNome(req.nome());
        if (perfilExiste) {
            throw new BusinessException("O perfil informado já existe.");
        }
        Perfil perfilCriado = repository.save(mapper.toEntity(req));
        return mapper.toPerfilDto(perfilCriado);
    }

    @Override
    public List<PerfilResumoResponse> buscarResumoPerfis() {
        List<Perfil> perfis = repository.findAll();
        return perfis.stream()
                .map(mapper::toPerfilResumoDto).toList();
    }

    @Override
    public PerfilResponse buscarDetalhesPerfil(Long id) {
        Perfil perfil = buscarPerfil(id);
        return mapper.toPerfilDto(perfil);
    }

    @Override
    @Transactional
    public void atualizarPerfil(AtualizarPerfilRequest req, Long id) {
        Perfil perfil = buscarPerfil(id);
        perfil.atualizarPerfil(req);
    }

    @Override
    @Transactional
    public void desativarPerfil(Long id) {
        Perfil perfil = buscarPerfil(id);
        perfil.setAtivo(false);
    }

    public Perfil buscarPerfil(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado."));
    }
}
