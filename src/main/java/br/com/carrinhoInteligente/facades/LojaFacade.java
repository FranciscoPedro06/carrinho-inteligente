package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.LojaApplication;
import br.com.carrinhoInteligente.models.LojaModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LojaFacade {
    private final LojaApplication application;

    public LojaFacade(LojaApplication application) {
        this.application = application;
    }

    public void salvar(LojaModel loja) {
        application.salvar(loja);
    }

    public List<LojaModel> listarTodos() {
        return application.listarTodas();
    }

    public Optional<LojaModel> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, LojaModel loja) {
        return application.atualizar(id, loja);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
