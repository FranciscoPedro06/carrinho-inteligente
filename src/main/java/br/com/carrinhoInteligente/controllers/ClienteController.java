package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Cliente;
import br.com.carrinhoInteligente.facades.ClienteFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteFacade facade;
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    public ClienteController(ClienteFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> salvar(@RequestBody Cliente cliente) {
        logger.info("POST /adicionar - Recebendo novo cliente: {}", cliente);
        try {
            Cliente salvo = facade.salvar(cliente);
            logger.info("Cliente criado com sucesso: ID {}", salvo.getIdCliente());
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao salvar cliente: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao salvar cliente: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao salvar cliente: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> listarTodos() {
        logger.info("GET / - Listando todos os clientes");
        List<Cliente> clientes = facade.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        logger.info("GET /{} - Buscando cliente por ID", id);
        Optional<Cliente> cliente = facade.buscarPorId(id);
        if (cliente.isPresent()) {
            logger.info("Cliente encontrado: ID {}", id);
            return ResponseEntity.ok(cliente.get());
        }
        logger.warn("Cliente não encontrado: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Cliente com ID " + id + " não encontrado");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        logger.info("PUT /editar/{} - Atualizando cliente", id);
        try {
            boolean atualizado = facade.atualizar(id, cliente);
            if (atualizado) {
                logger.info("Cliente atualizado com sucesso: ID {}", id);
                return ResponseEntity.ok(true);
            }
            logger.warn("Cliente não encontrado para atualização: ID {}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com ID " + id + " não encontrado");
        } catch (IllegalArgumentException e) {
            logger.error("Erro de validação ao atualizar cliente: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Erro interno ao atualizar cliente: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno ao atualizar cliente: " + e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable int id) {
        logger.info("DELETE /excluir/{} - Deletando cliente", id);
        boolean deletado = facade.deletar(id);
        if (deletado) {
            logger.info("Cliente deletado com sucesso: ID {}", id);
            return ResponseEntity.ok(true);
        }
        logger.warn("Cliente não encontrado para deleção: ID {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Cliente com ID " + id + " não encontrado");
    }
}