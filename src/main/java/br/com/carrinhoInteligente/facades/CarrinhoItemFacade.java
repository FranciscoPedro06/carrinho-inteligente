package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.application.CarrinhoItemApplication;
import br.com.carrinhoInteligente.entities.CarrinhoItem;

import java.util.List;
import java.util.Optional;

public class CarrinhoItemFacade {
    private final CarrinhoItemApplication application;

    public CarrinhoItemFacade(CarrinhoItemApplication application) {
        this.application = application;
    }

    // CREATE
    public void adicionarItem(CarrinhoItem item) {
        application.salvarItem(item);
    }

    // READ
    public List<CarrinhoItem> obterItens() {
        return application.listarItens();
    }

    public Optional<CarrinhoItem> obterItemPorId(int id) {
        return application.buscarItemPorId(id);
    }

    // UPDATE
    public boolean editarItem(int id, CarrinhoItem item) {
        return application.atualizarItem(id, item);
    }

    // DELETE
    public boolean removerItem(int id) {
        return application.deletarItem(id);
    }
}
