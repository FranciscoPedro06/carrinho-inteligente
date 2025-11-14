package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Cliente;
import br.com.carrinhoInteligente.facades.ClienteFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteFacade facade;

    public ClienteController(ClienteFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody Cliente cliente) {
        facade.salvar(cliente);
    }

    @GetMapping("/")
    public List<Cliente> listarTodos() {
        return facade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable int id) {
        return facade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        return facade.atualizar(id, cliente);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return facade.deletar(id);
    }
}
