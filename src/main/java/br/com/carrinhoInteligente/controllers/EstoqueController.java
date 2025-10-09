package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.facades.EstoqueFacade;
import br.com.carrinhoInteligente.models.EstoqueModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    private final EstoqueFacade facade;

    @Autowired
    public EstoqueController(EstoqueFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody EstoqueModel estoque) {
        facade.salvar(estoque);
    }

    @GetMapping("/")
    public List<EstoqueModel> listarTodos() {
        return facade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<EstoqueModel> buscarPorId(@PathVariable int id) {
        return facade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody EstoqueModel estoque) {
        return facade.atualizar(id, estoque);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return facade.deletar(id);
    }
}
