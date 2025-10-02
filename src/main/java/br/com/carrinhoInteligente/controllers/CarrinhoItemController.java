package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.facades.CarrinhoItemFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinho-itens")
public class CarrinhoItemController {

    private final CarrinhoItemFacade carrinhoItemFacade;

    @Autowired
    public CarrinhoItemController(CarrinhoItemFacade carrinhoItemFacade) {
        this.carrinhoItemFacade = carrinhoItemFacade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody CarrinhoItem item) {
        carrinhoItemFacade.salvar(item);
    }

    @GetMapping("/")
    public List<CarrinhoItem> listarTodos() {
        return carrinhoItemFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<CarrinhoItem> buscarPorId(@PathVariable int id) {
        return carrinhoItemFacade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody CarrinhoItem item) {
        return carrinhoItemFacade.atualizar(id, item);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return carrinhoItemFacade.deletar(id);
    }
}
