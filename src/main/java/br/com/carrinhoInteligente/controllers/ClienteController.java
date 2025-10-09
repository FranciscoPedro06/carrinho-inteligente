package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.facades.ClienteFacade;
import br.com.carrinhoInteligente.models.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteFacade facade;

    @Autowired
    public ClienteController(ClienteFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody ClienteModel cliente) {
        facade.salvar(cliente);
    }

    @GetMapping("/")
    public List<ClienteModel> listarTodos() {
        return facade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<ClienteModel> buscarPorId(@PathVariable int id) {
        return facade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody ClienteModel cliente) {
        return facade.atualizar(id, cliente);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return facade.deletar(id);
    }
}
