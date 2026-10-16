package com.leonardo.suprione.usuario;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
@CrossOrigin("*")
public class UsuarioController {
    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody UsuarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarUsuario(request));
    }
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> buscarUsuarios() {
        return ResponseEntity.ok(service.buscarUsuarios());
    }
    @GetMapping("{id}")
    public ResponseEntity<UsuarioResponse> buscarUsuarioPeloId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarUsuarioPeloId(id));
    }
    @PutMapping("/{id}/atualizar")
    public ResponseEntity<Void> atualizarUsuario(@RequestBody AtualizarUsuarioRequest req, @PathVariable Long id) {
        service.atualizarUsuario(req, id);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("{id}/desativar")
    public ResponseEntity<Void> desativarUsuario(@PathVariable Long id) {
        service.desativarUsuarioPeloId(id);
        return ResponseEntity.ok().build();
    }
}
