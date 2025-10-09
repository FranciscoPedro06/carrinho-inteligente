package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.ProdutoApplication;
import br.com.carrinhoInteligente.models.ProdutoModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoFacade {
    private final ProdutoApplication application;

    public ProdutoFacade(ProdutoApplication application) {
        this.application = application;
    }

    public void criarProduto(ProdutoModel produto) {
        application.salvar(produto);
    }

    public List<ProdutoModel> obterTodosProdutos() {
        return application.listarTodos();
    }

    public Optional<ProdutoModel> obterProdutoPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean editarProduto(int id, ProdutoModel produto) {
        return application.atualizar(id, produto);
    }

    public boolean removerProduto(int id) {
        return application.deletar(id);
    }
}
