package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.CarrinhoItemApplication;
import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.models.CarrinhoItemModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarrinhoItemFacade {
    private final CarrinhoItemApplication application;

    public CarrinhoItemFacade(CarrinhoItemApplication application) {
        this.application = application;
    }

    public void salvar(CarrinhoItem item) {
        application.salvar(item);
    }

    public List<CarrinhoItem> listarTodos() {
        return application.listarTodos();
    }

    public Optional<CarrinhoItem> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, CarrinhoItem item) {
        return application.atualizar(id, item);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
