package com.leonardo.suprione.perfil;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/perfil")
@CrossOrigin("*")
@RestController
@AllArgsConstructor
public class PerfilController {
    private final PerfilService service;

    @PostMapping
    public ResponseEntity<PerfilResponse> criarPerfil(@RequestBody PerfilRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarPerfil(req));
    }
    @GetMapping("/resumo")
    public ResponseEntity<List<PerfilResumoResponse>> buscarResumoPerfis() {
        return ResponseEntity.ok().body(service.buscarResumoPerfis());
    }
    @GetMapping("/{id}/detalhes")
    public ResponseEntity<PerfilResponse> buscarDetalhesPerfil(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarDetalhesPerfil(id));
    }
    @PutMapping("{id}/atualizar")
    public ResponseEntity<Void> atualizarPerfil(@PathVariable Long id, @RequestBody AtualizarPerfilRequest req) {
        service.atualizarPerfil(req, id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("{id}/desativar")
    public ResponseEntity<Void> desativarPerfil(@PathVariable Long id) {
        service.desativarPerfil(id);
        return ResponseEntity.noContent().build();
    }
}
