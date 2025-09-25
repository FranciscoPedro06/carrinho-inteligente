package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.application.CarrinhoFisicoApplication;
import br.com.carrinhoInteligente.entities.CarrinhoFisico;

import java.util.List;
import java.util.Optional;

public class CarrinhoFisicoFacade {
    private final CarrinhoFisicoApplication application;

    public CarrinhoFisicoFacade(CarrinhoFisicoApplication application) {
        this.application = application;
    }

    // CREATE
    public void criarCarrinho(CarrinhoFisico carrinho) {
        application.salvarCarrinho(carrinho);
    }

    // READ
    public List<CarrinhoFisico> obterTodosCarrinhos() {
        return application.listarCarrinhos();
    }

    public Optional<CarrinhoFisico> obterCarrinhoPorId(int id) {
        return application.buscarCarrinhoPorId(id);
    }

    // UPDATE
    public boolean editarCarrinho(int id, CarrinhoFisico carrinho) {
        return application.atualizarCarrinho(id, carrinho);
    }

    // DELETE
    public boolean removerCarrinho(int id) {
        return application.deletarCarrinho(id);
    }
}
