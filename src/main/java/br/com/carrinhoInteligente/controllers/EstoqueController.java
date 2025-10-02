package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Estoque;
import br.com.carrinhoInteligente.facades.EstoqueFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estoques")
public class EstoqueController {

    private final EstoqueFacade estoqueFacade;

    @Autowired
    public EstoqueController(EstoqueFacade estoqueFacade) {
        this.estoqueFacade = estoqueFacade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody Estoque estoque) {
        estoqueFacade.salvar(estoque);
    }

    @GetMapping("/")
    public List<Estoque> listarTodos() {
        return estoqueFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Estoque> buscarPorId(@PathVariable int id) {
        return estoqueFacade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody Estoque estoque) {
        return estoqueFacade.atualizar(id, estoque);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return estoqueFacade.deletar(id);
    }
}
