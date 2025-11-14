package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.facades.CarrinhoItemFacade;
import br.com.carrinhoInteligente.models.CarrinhoItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinho-item")
public class CarrinhoItemController {

    private final CarrinhoItemFacade facade;

    @Autowired
    public CarrinhoItemController(CarrinhoItemFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody CarrinhoItem item) {
        facade.salvar(item);
    }

    @GetMapping("/")
    public List<CarrinhoItem> listarTodos() {
        return facade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<CarrinhoItem> buscarPorId(@PathVariable int id) {
        return facade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody CarrinhoItem item) {
        return facade.atualizar(id, item);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return facade.deletar(id);
    }
}
