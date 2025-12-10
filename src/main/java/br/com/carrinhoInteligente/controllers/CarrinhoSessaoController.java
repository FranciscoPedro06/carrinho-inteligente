package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import br.com.carrinhoInteligente.facades.CarrinhoSessaoFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinho-sessao")
public class CarrinhoSessaoController {

    private final CarrinhoSessaoFacade facade;
    private static final Logger logger = LoggerFactory.getLogger(CarrinhoSessaoController.class);

    @Autowired
    public CarrinhoSessaoController(CarrinhoSessaoFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> salvar(@RequestBody CarrinhoSessao sessao) {
        logger.info("POST /adicionar - Recebendo nova sessão: {}", sessao);
        try {
            CarrinhoSessao salvo = facade.salvar(sessao);
            logger.info("Sessão criada com sucesso: ID {}", salvo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao salvar sessão: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao salvar sessão: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao salvar sessão do carrinho: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<CarrinhoSessao>> listarTodos() {
        logger.info("GET / - Listando todas as sessões");
        List<CarrinhoSessao> sessoes = facade.listarTodos();
        return ResponseEntity.ok(sessoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        logger.info("GET /{} - Buscando sessão por ID", id);
        Optional<CarrinhoSessao> sessao = facade.buscarPorId(id);
        if (sessao.isPresent()) {
            logger.info("Sessão encontrada: ID {}", id);
            return ResponseEntity.ok(sessao.get());
        }
        logger.warn("Sessão não encontrada: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Sessão do carrinho com ID " + id + " não encontrada");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody CarrinhoSessao sessao) {
        logger.info("PUT /editar/{} - Atualizando sessão", id);
        try {
            boolean atualizado = facade.atualizar(id, sessao);
            if (atualizado) {
                logger.info("Sessão atualizada com sucesso: ID {}", id);
                return ResponseEntity.ok(true);
            }
            logger.warn("Sessão não encontrada para atualização: ID {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Sessão do carrinho com ID " + id + " não encontrada");
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao atualizar sessão: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao atualizar sessão: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao atualizar sessão do carrinho: " + e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable int id) {
        logger.info("DELETE /excluir/{} - Deletando sessão", id);
        boolean deletado = facade.deletar(id);
        if (deletado) {
            logger.info("Sessão deletada com sucesso: ID {}", id);
            return ResponseEntity.ok(true);
        }
        logger.warn("Sessão não encontrada para deleção: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Sessão do carrinho com ID " + id + " não encontrada");
    }
}