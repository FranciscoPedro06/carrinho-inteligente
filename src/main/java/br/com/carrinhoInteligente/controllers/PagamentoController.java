package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Pagamento;
import br.com.carrinhoInteligente.facades.PagamentoFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PagamentoFacade facade;
    private static final Logger logger = LoggerFactory.getLogger(PagamentoController.class);

    @Autowired
    public PagamentoController(PagamentoFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> salvar(@RequestBody Pagamento pagamento) {
        logger.info("POST /adicionar - Recebendo novo pagamento: {}", pagamento);
        try {
            Pagamento salvo = facade.salvar(pagamento);
            logger.info("Pagamento criado com sucesso: ID {}", salvo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao salvar pagamento: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao salvar pagamento: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao salvar pagamento: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Pagamento>> listarTodos() {
        logger.info("GET / - Listando todos os pagamentos");
        List<Pagamento> pagamentos = facade.listarTodos();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        logger.info("GET /{} - Buscando pagamento por ID", id);
        Optional<Pagamento> pagamento = facade.buscarPorId(id);
        if (pagamento.isPresent()) {
            logger.info("Pagamento encontrado: ID {}", id);
            return ResponseEntity.ok(pagamento.get());
        }
        logger.warn("Pagamento não encontrado: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pagamento com ID " + id + " não encontrado");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody Pagamento pagamento) {
        logger.info("PUT /editar/{} - Atualizando pagamento", id);
        try {
            boolean atualizado = facade.atualizar(id, pagamento);
            if (atualizado) {
                logger.info("Pagamento atualizado com sucesso: ID {}", id);
                return ResponseEntity.ok(true);
            }
            logger.warn("Pagamento não encontrado para atualização: ID {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pagamento com ID " + id + " não encontrado");
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao atualizar pagamento: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao atualizar pagamento: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao atualizar pagamento: " + e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable int id) {
        logger.info("DELETE /excluir/{} - Deletando pagamento", id);
        boolean deletado = facade.deletar(id);
        if (deletado) {
            logger.info("Pagamento deletado com sucesso: ID {}", id);
            return ResponseEntity.ok(true);
        }
        logger.warn("Pagamento não encontrado para deleção: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Pagamento com ID " + id + " não encontrado");
    }
}