package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import br.com.carrinhoInteligente.facades.CarrinhoSessaoFacade;
import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinho-sessao")
public class CarrinhoSessaoController {

    private final CarrinhoSessaoFacade facade;

    @Autowired
    public CarrinhoSessaoController(CarrinhoSessaoFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody CarrinhoSessao sessao) {
        facade.salvar(sessao);
    }

    @GetMapping("/")
    public List<CarrinhoSessao> listarTodos() {
        return facade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<CarrinhoSessao> buscarPorId(@PathVariable int id) {
        return facade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody CarrinhoSessao sessao) {
        return facade.atualizar(id, sessao);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return facade.deletar(id);
    }
}
