package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Produto;
import br.com.carrinhoInteligente.facades.ProdutoFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoFacade produtoFacade;
    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    public ProdutoController(ProdutoFacade produtoFacade) {
        this.produtoFacade = produtoFacade;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto) {
        logger.info("POST /adicionar - Recebendo novo produto: {}", produto);
        try {
            Produto salvo = produtoFacade.criarProduto(produto);
            logger.info("Produto criado com sucesso: ID {}", salvo.getIdProduto());
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao criar produto: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao criar produto: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao criar produto: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Produto>> obterTodosProdutos() {
        logger.info("GET / - Listando todos os produtos");
        List<Produto> produtos = produtoFacade.obterTodosProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterProdutoPorId(@PathVariable int id) {
        logger.info("GET /{} - Buscando produto por ID", id);
        Optional<Produto> produto = produtoFacade.obterProdutoPorId(id);
        if (produto.isPresent()) {
            logger.info("Produto encontrado: ID {}", id);
            return ResponseEntity.ok(produto.get());
        }
        logger.warn("Produto não encontrado: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Produto com ID " + id + " não encontrado");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarProduto(@PathVariable int id, @RequestBody Produto produto) {
        logger.info("PUT /editar/{} - Editando produto", id);
        try {
            boolean editado = produtoFacade.editarProduto(id, produto);
            if (editado) {
                logger.info("Produto editado com sucesso: ID {}", id);
                return ResponseEntity.ok(true);
            }
            logger.warn("Produto não encontrado para edição: ID {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto com ID " + id + " não encontrado");
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao editar produto: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao editar produto: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao editar produto: " + e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> removerProduto(@PathVariable int id) {
        logger.info("DELETE /excluir/{} - Removendo produto", id);
        boolean removido = produtoFacade.removerProduto(id);
        if (removido) {
            logger.info("Produto removido com sucesso: ID {}", id);
            return ResponseEntity.ok(true);
        }
        logger.warn("Produto não encontrado para remoção: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Produto com ID " + id + " não encontrado");
    }
}