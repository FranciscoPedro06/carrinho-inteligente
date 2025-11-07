package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.application.CarrinhoSessaoApplication;
import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho-sessao")
public class CarrinhoSessaoController {

    private final CarrinhoSessaoApplication application;

    public CarrinhoSessaoController(CarrinhoSessaoApplication application) {
        this.application = application;
    }

    @PostMapping
    public ResponseEntity<CarrinhoSessao> criar(@RequestBody CarrinhoSessao entity) {
        return ResponseEntity.ok(application.criar(entity));
    }

    @GetMapping
    public ResponseEntity<List<CarrinhoSessao>> listar() {
        return ResponseEntity.ok(application.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoSessao> buscarPorId(@PathVariable int id) {
        CarrinhoSessao sessao = application.buscarPorId(id);
        return sessao != null ? ResponseEntity.ok(sessao) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrinhoSessao> atualizar(@PathVariable int id, @RequestBody CarrinhoSessao entity) {
        CarrinhoSessao atualizado = application.atualizar(id, entity);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        application.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
