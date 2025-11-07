package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.applications.CarrinhoItemApplication;
import br.com.carrinhoInteligente.entities.CarrinhoItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho-itens")
public class CarrinhoItemController {

    private final CarrinhoItemApplication application;

    public CarrinhoItemController(CarrinhoItemApplication application) {
        this.application = application;
    }

    @PostMapping
    public ResponseEntity<CarrinhoItem> criar(@RequestBody CarrinhoItem item) {
        return ResponseEntity.ok(application.salvar(item));
    }

    @GetMapping
    public ResponseEntity<List<CarrinhoItem>> listarTodos() {
        return ResponseEntity.ok(application.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoItem> buscarPorId(@PathVariable int id) {
        return application.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody CarrinhoItem item) {
        boolean atualizado = application.atualizar(id, item);
        return atualizado
                ? ResponseEntity.ok("Item atualizado com sucesso!")
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable int id) {
        boolean deletado = application.deletar(id);
        return deletado
                ? ResponseEntity.ok("Item removido com sucesso!")
                : ResponseEntity.notFound().build();
    }
}
