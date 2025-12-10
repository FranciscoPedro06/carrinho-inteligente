package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Estoque;
import br.com.carrinhoInteligente.facades.EstoqueFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    private final EstoqueFacade facade;
    private static final Logger logger = LoggerFactory.getLogger(EstoqueController.class);

    @Autowired
    public EstoqueController(EstoqueFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> salvar(@RequestBody Estoque estoque) {
        logger.info("POST /adicionar - Recebendo novo estoque: {}", estoque);
        try {
            Estoque salvo = facade.salvar(estoque);
            logger.info("Estoque criado com sucesso: ID {}", salvo.getIdEstoque());
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao salvar estoque: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao salvar estoque: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao salvar estoque: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Estoque>> listarTodos() {
        logger.info("GET / - Listando todos os estoques");
        List<Estoque> estoques = facade.listarTodos();
        return ResponseEntity.ok(estoques);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        logger.info("GET /{} - Buscando estoque por ID", id);
        Optional<Estoque> estoque = facade.buscarPorId(id);
        if (estoque.isPresent()) {
            logger.info("Estoque encontrado: ID {}", id);
            return ResponseEntity.ok(estoque.get());
        }
        logger.warn("Estoque não encontrado: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Estoque com ID " + id + " não encontrado");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody Estoque estoque) {
        logger.info("PUT /editar/{} - Atualizando estoque", id);
        try {
            boolean atualizado = facade.atualizar(id, estoque);
            if (atualizado) {
                logger.info("Estoque atualizado com sucesso: ID {}", id);
                return ResponseEntity.ok(true);
            }
            logger.warn("Estoque não encontrado para atualização: ID {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Estoque com ID " + id + " não encontrado");
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao atualizar estoque: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao atualizar estoque: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao atualizar estoque: " + e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable int id) {
        logger.info("DELETE /excluir/{} - Deletando estoque", id);
        boolean deletado = facade.deletar(id);
        if (deletado) {
            logger.info("Estoque deletado com sucesso: ID {}", id);
            return ResponseEntity.ok(true);
        }
        logger.warn("Estoque não encontrado para deleção: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Estoque com ID " + id + " não encontrado");
    }
}