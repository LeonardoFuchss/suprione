package com.leonardo.suprione.unidademedida;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidade-medida")
@AllArgsConstructor
@CrossOrigin("*")
public class UnidadeMedidaController {
    private final UnidadeMedidaService service;

    @PostMapping
    public ResponseEntity<UnidadeMedidaResponse> criarUnidadeMedida(@RequestBody UnidadeMedidaRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarUnidadeMedida(req));
    }
    @GetMapping()
    public ResponseEntity<List<UnidadeMedidaResponse>> buscarUnidadesMedidas() {
        return ResponseEntity.ok(service.buscarUnidadeMedidas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UnidadeMedidaResponse> buscarDetalhesUnidadeMedida(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarDetalhesUnidadeMedida(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarUnidadeMedida(@RequestBody UnidadeMedidaRequest req, @PathVariable Long id) {
        service.atualizarUnidadeMedida(req, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping("{id}")
    public ResponseEntity<Void> desativarUnidadeMedida(@PathVariable Long id) {
        service.desativarUnidadeMedida(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
