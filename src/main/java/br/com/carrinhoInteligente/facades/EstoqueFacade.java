package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.EstoqueApplication;
import br.com.carrinhoInteligente.models.EstoqueModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EstoqueFacade {
    private final EstoqueApplication application;

    public EstoqueFacade(EstoqueApplication application) {
        this.application = application;
    }

    public void salvar(EstoqueModel estoque) {
        application.salvar(estoque);
    }

    public List<EstoqueModel> listarTodos() {
        return application.listarTodos();
    }

    public Optional<EstoqueModel> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, EstoqueModel estoque) {
        return application.atualizar(id, estoque);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
