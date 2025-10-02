package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.EstoqueApplication;
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
        application.salvar(estoque);
    }

    // READ
    public List<Estoque> listarTodos() {
        return application.listarTodos();
    }

    public Optional<Estoque> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, Estoque estoque) {
        return application.atualizar(id, estoque);
    }

    // DELETE
    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
