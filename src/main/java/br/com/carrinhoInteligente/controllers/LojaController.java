package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Loja;
import br.com.carrinhoInteligente.facades.LojaFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lojas")
public class LojaController {

    private final LojaFacade lojaFacade;
    private static final Logger logger = LoggerFactory.getLogger(LojaController.class);

    @Autowired
    public LojaController(LojaFacade lojaFacade) {
        this.lojaFacade = lojaFacade;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> salvar(@RequestBody Loja loja) {
        logger.info("POST /adicionar - Recebendo nova loja: {}", loja);
        try {
            Loja salvo = lojaFacade.salvar(loja);
            logger.info("Loja criada com sucesso: ID {}", salvo.getIdLoja());
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao salvar loja: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao salvar loja: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao salvar loja: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Loja>> listarTodos() {
        logger.info("GET / - Listando todas as lojas");
        List<Loja> lojas = lojaFacade.listarTodos();
        return ResponseEntity.ok(lojas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        logger.info("GET /{} - Buscando loja por ID", id);
        Optional<Loja> loja = lojaFacade.buscarPorId(id);
        if (loja.isPresent()) {
            logger.info("Loja encontrada: ID {}", id);
            return ResponseEntity.ok(loja.get());
        }
        logger.warn("Loja não encontrada: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Loja com ID " + id + " não encontrada");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody Loja loja) {
        logger.info("PUT /editar/{} - Atualizando loja", id);
        try {
            boolean atualizado = lojaFacade.atualizar(id, loja);
            if (atualizado) {
                logger.info("Loja atualizada com sucesso: ID {}", id);
                return ResponseEntity.ok(true);
            }
            logger.warn("Loja não encontrada para atualização: ID {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Loja com ID " + id + " não encontrada");
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao atualizar loja: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao atualizar loja: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao atualizar loja: " + e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable int id) {
        logger.info("DELETE /excluir/{} - Deletando loja", id);
        boolean deletado = lojaFacade.deletar(id);
        if (deletado) {
            logger.info("Loja deletada com sucesso: ID {}", id);
            return ResponseEntity.ok(true);
        }
        logger.warn("Loja não encontrada para deleção: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Loja com ID " + id + " não encontrada");
    }
}