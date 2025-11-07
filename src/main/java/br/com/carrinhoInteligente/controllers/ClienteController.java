package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.application.ClienteApplication;
import br.com.carrinhoInteligente.entities.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteApplication application;

    public ClienteController(ClienteApplication application) {
        this.application = application;
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente entity) {
        return ResponseEntity.ok(application.criar(entity));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(application.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable int id) {
        Cliente cliente = application.buscarPorId(id);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable int id, @RequestBody Cliente entity) {
        Cliente atualizado = application.atualizar(id, entity);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        application.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
