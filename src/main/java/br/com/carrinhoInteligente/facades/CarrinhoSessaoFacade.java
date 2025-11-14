package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.CarrinhoSessaoApplication;
import br.com.carrinhoInteligente.entities.CarrinhoSessao;
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

    public void salvar(CarrinhoSessao sessao) {
        application.salvar(sessao);
    }

    public List<CarrinhoSessao> listarTodos() {
        return application.listarTodos();
    }

    public Optional<CarrinhoSessao> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, CarrinhoSessao sessao) {
        return application.atualizar(id, sessao);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
