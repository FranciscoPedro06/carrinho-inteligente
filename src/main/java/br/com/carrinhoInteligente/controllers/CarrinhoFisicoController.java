package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.facades.CarrinhoFisicoFacade;
import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinhoFisico")
public class CarrinhoFisicoController {

    private final CarrinhoFisicoFacade facade;

    @Autowired
    public CarrinhoFisicoController(CarrinhoFisicoFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody CarrinhoFisicoModel carrinho) {
        facade.salvar(carrinho);
    }

    @GetMapping("/")
    public List<CarrinhoFisicoModel> listarTodos() {
        return facade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<CarrinhoFisicoModel> buscarPorId(@PathVariable int id) {
        return facade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody CarrinhoFisicoModel carrinho) {
        return facade.atualizar(id, carrinho);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return facade.deletar(id);
    }
}
