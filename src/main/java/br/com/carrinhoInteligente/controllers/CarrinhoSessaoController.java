package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import br.com.carrinhoInteligente.facades.CarrinhoSessaoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinho-sessoes")
public class CarrinhoSessaoController {

    private final CarrinhoSessaoFacade carrinhoSessaoFacade;

    @Autowired
    public CarrinhoSessaoController(CarrinhoSessaoFacade carrinhoSessaoFacade) {
        this.carrinhoSessaoFacade = carrinhoSessaoFacade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody CarrinhoSessao sessao) {
        carrinhoSessaoFacade.salvar(sessao);
    }

    @GetMapping("/")
    public List<CarrinhoSessao> listarTodos() {
        return carrinhoSessaoFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<CarrinhoSessao> buscarPorId(@PathVariable int id) {
        return carrinhoSessaoFacade.buscarPorid(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody CarrinhoSessao sessao) {
        return carrinhoSessaoFacade.atualizar(id, sessao);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return carrinhoSessaoFacade.deletar(id);
    }
}
