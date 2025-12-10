package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.CarrinhoFisico;
import br.com.carrinhoInteligente.facades.CarrinhoFisicoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinhoFisico")
public class CarrinhoFisicoController {

    private final CarrinhoFisicoFacade facade;

    @Autowired
    public CarrinhoFisicoController(CarrinhoFisicoFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> salvar(@RequestBody CarrinhoFisico carrinho) {
        try {
            CarrinhoFisico salvo = facade.salvar(carrinho);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar carrinho físico");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<CarrinhoFisico>> listarTodos() {
        List<CarrinhoFisico> carrinhos = facade.listarTodos();
        return ResponseEntity.ok(carrinhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        Optional<CarrinhoFisico> carrinho = facade.buscarPorId(id);
        if (carrinho.isPresent()) {
            return ResponseEntity.ok(carrinho.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrinho físico com ID " + id + " não encontrado");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody CarrinhoFisico carrinho) {
        try {
            boolean atualizado = facade.atualizar(id, carrinho);
            if (atualizado) {
                return ResponseEntity.ok(true);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrinho físico com ID " + id + " não encontrado");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar carrinho físico");
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable int id) {
        boolean deletado = facade.deletar(id);
        if (deletado) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrinho físico com ID " + id + " não encontrado");
    }
}