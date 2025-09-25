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
    public void salvar(Estoque estoque) {
        application.salvarEstoque(estoque);
    }

    // READ
    public List<Estoque> listarTodos() {
        return application.listarEstoques();
    }

    public Optional<Estoque> buscarPorId(int id) {
        return application.buscarEstoquePorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, Estoque estoque) {
        return application.atualizarEstoque(id, estoque);
    }

    // DELETE
    public boolean deletar(int id) {
        return application.deletarEstoque(id);
    }
}
