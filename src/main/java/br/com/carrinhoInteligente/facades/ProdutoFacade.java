package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.ProdutoApplication;
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
        application.salvar(produto);
    }

    // READ
    public List<Produto> obterTodosProdutos() {
        return application.listarTodos();
    }

    public Optional<Produto> obterProdutoPorId(int id) {
        return application.buscarPorId(id);
    }

    // UPDATE
    public boolean editarProduto(int id, Produto produto) {
        return application.atualizar(id, produto);
    }

    // DELETE
    public boolean removerProduto(int id) {
        return application.deletar(id);
    }
}
