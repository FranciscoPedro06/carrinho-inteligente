package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.CarrinhoSessaoApplication;
import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarrinhoSessaoFacade {
    private final CarrinhoSessaoApplication application;

    public CarrinhoSessaoFacade(CarrinhoSessaoApplication application) {
        this.application = application;
    }

    public void salvar(CarrinhoSessaoModel sessao) {
        application.salvar(sessao);
    }

    public List<CarrinhoSessaoModel> listarTodos() {
        return application.listarTodos();
    }

    public Optional<CarrinhoSessaoModel> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, CarrinhoSessaoModel sessao) {
        return application.atualizar(id, sessao);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
