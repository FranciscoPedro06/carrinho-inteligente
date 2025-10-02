package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Cliente;
import br.com.carrinhoInteligente.facades.ClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteFacade clienteFacade;

    @Autowired
    public ClienteController(ClienteFacade clienteFacade) {
        this.clienteFacade = clienteFacade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody Cliente cliente) {
        clienteFacade.salvar(cliente);
    }

    @GetMapping("/")
    public List<Cliente> listarTodos() {
        return clienteFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable int id) {
        return clienteFacade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        return clienteFacade.atualizar(id, cliente);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return clienteFacade.deletar(id);
    }
}
