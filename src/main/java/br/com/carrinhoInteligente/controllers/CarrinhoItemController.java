package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.facades.CarrinhoItemFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinho-item")
public class CarrinhoItemController {

    private final CarrinhoItemFacade facade;

    @Autowired
    public CarrinhoItemController(CarrinhoItemFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> salvar(@RequestBody CarrinhoItem item) {
        try {
            CarrinhoItem salvo = facade.salvar(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar item do carrinho");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<CarrinhoItem>> listarTodos() {
        List<CarrinhoItem> itens = facade.listarTodos();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        Optional<CarrinhoItem> item = facade.buscarPorId(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do carrinho com ID " + id + " não encontrado");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody CarrinhoItem item) {
        try {
            boolean atualizado = facade.atualizar(id, item);
            if (atualizado) {
                return ResponseEntity.ok(true);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do carrinho com ID " + id + " não encontrado");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar item do carrinho");
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable int id) {
        boolean deletado = facade.deletar(id);
        if (deletado) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item do carrinho com ID " + id + " não encontrado");
    }
}