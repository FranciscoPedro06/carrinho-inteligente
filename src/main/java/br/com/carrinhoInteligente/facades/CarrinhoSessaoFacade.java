package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.application.CarrinhoSessaoApplication;
import br.com.carrinhoInteligente.entities.CarrinhoSessao;

import java.util.List;
import java.util.Optional;

public class CarrinhoSessaoFacade {
    private final CarrinhoSessaoApplication application;

    public CarrinhoSessaoFacade(CarrinhoSessaoApplication application) {
        this.application = application;
    }

    // CREATE
    public void criarSessao(CarrinhoSessao sessao) {
        application.salvarSessao(sessao);
    }

    // READ
    public List<CarrinhoSessao> obterTodasSessoes() {
        return application.listarSessoes();
    }

    public Optional<CarrinhoSessao> obterSessaoPorId(int id) {
        return application.buscarSessaoPorId(id);
    }

    // UPDATE
    public boolean editarSessao(int id, CarrinhoSessao sessao) {
        return application.atualizarSessao(id, sessao);
    }

    // DELETE
    public boolean removerSessao(int id) {
        return application.deletarSessao(id);
    }
}
