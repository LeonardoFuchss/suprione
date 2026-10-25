package com.leonardo.suprione.unidademedida;

import com.leonardo.suprione.exception.BusinessException;
import com.leonardo.suprione.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UnidadeMedidaServiceImpl implements UnidadeMedidaService {
    private final UnidadeMedidaMapper mapper;
    private final UnidadeMedidaRepository repository;

    @Override
    @Transactional
    public UnidadeMedidaResponse criarUnidadeMedida(UnidadeMedidaRequest req) {
        if (repository.existsByNome(req.nome())) {
            throw new BusinessException("A unidade de medida informada já existe.");
        }
        UnidadeMedida unidadeMedida = mapper.toEntity(req);
        unidadeMedida.setAtivo(true);
        repository.save(unidadeMedida);
        return mapper.toUnidadeMedidaResponse(unidadeMedida);
    }

    @Override
    public List<UnidadeMedidaResponse> buscarUnidadeMedidas() {
        List<UnidadeMedida> unidadeMedidas = repository.findAll();
        return unidadeMedidas.stream()
                .map(mapper::toUnidadeMedidaResponse).toList();
    }

    @Override
    public UnidadeMedidaResponse buscarDetalhesUnidadeMedida(Long id) {
        UnidadeMedida unidadeMedida = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unidade de medida não encontrada."));
        return mapper.toUnidadeMedidaResponse(unidadeMedida);
    }

    @Override
    @Transactional
    public void atualizarUnidadeMedida(UnidadeMedidaRequest req, Long id) {
        UnidadeMedida unidadeMedida = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unidade de medida não encontrada."));
        unidadeMedida.atualizarUnidadeMedida(req);
    }

    @Override
    @Transactional
    public void desativarUnidadeMedida(Long id) {
        UnidadeMedida unidadeMedida = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Unidade de medida não encontrada."));
        unidadeMedida.setAtivo(false);
    }
}
