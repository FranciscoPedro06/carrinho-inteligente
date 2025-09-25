package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.application.EstoqueApplication;
import br.com.carrinhoInteligente.entities.Estoque;

import java.util.List;
import java.util.Optional;

public class EstoqueFacade {
    private final EstoqueApplication application;

    public EstoqueFacade(EstoqueApplication application) {
        this.application = application;
    }

    // CREATE
    public void adicionarEstoque(Estoque estoque) {
        application.salvarEstoque(estoque);
    }

    // READ
    public List<Estoque> obterTodosEstoques() {
        return application.listarEstoques();
    }

    public Optional<Estoque> obterEstoquePorId(int id) {
        return application.buscarEstoquePorId(id);
    }

    // UPDATE
    public boolean editarEstoque(int id, Estoque estoque) {
        return application.atualizarEstoque(id, estoque);
    }

    // DELETE
    public boolean removerEstoque(int id) {
        return application.deletarEstoque(id);
    }
}
