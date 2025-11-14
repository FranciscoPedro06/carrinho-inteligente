package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.EstoqueApplication;
import br.com.carrinhoInteligente.entities.Estoque;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstoqueFacade {

    private final EstoqueApplication application;

    public EstoqueFacade(EstoqueApplication application) {
        this.application = application;
    }

    public void salvar(Estoque estoque) {
        application.salvar(estoque);
    }

    public List<Estoque> listarTodos() {
        return application.listarTodos();
    }

    public Optional<Estoque> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, Estoque estoque) {
        return application.atualizar(id, estoque);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
