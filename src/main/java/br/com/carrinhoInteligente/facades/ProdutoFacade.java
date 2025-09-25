package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.application.ProdutoApplication;
import br.com.carrinhoInteligente.entities.Produto;

import java.util.List;
import java.util.Optional;

public class ProdutoFacade {
    private final ProdutoApplication application;

    public ProdutoFacade(ProdutoApplication application) {
        this.application = application;
    }

    // CREATE
    public void criarProduto(Produto produto) {
        application.salvarProduto(produto);
    }

    // READ
    public List<Produto> obterTodosProdutos() {
        return application.listarProdutos();
    }

    public Optional<Produto> obterProdutoPorId(int id) {
        return application.buscarProdutoPorId(id);
    }

    // UPDATE
    public boolean editarProduto(int id, Produto produto) {
        return application.atualizarProduto(id, produto);
    }

    // DELETE
    public boolean removerProduto(int id) {
        return application.deletarProduto(id);
    }
}
