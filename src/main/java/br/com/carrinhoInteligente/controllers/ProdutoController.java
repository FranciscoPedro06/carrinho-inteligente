package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.facades.ProdutoFacade;
import br.com.carrinhoInteligente.models.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoFacade produtoFacade;

    @Autowired
    public ProdutoController(ProdutoFacade produtoFacade) {
        this.produtoFacade = produtoFacade;
    }

    @PostMapping("/adicionar")
    public void criarProduto(@RequestBody ProdutoModel produto) {
        produtoFacade.criarProduto(produto);
    }

    @GetMapping("/")
    public List<ProdutoModel> obterTodosProdutos() {
        return produtoFacade.obterTodosProdutos();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> obterProdutoPorId(@PathVariable int id) {
        return produtoFacade.obterProdutoPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean editarProduto(@PathVariable int id, @RequestBody ProdutoModel produto) {
        return produtoFacade.editarProduto(id, produto);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean removerProduto(@PathVariable int id) {
        return produtoFacade.removerProduto(id);
    }
}
