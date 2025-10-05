package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.CarrinhoFisicoApplication;
import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarrinhoFisicoFacade {
    private final CarrinhoFisicoApplication application;

    public CarrinhoFisicoFacade(CarrinhoFisicoApplication application) {
        this.application = application;
    }

    public void salvar(CarrinhoFisicoModel carrinho) {
        application.salvar(carrinho);
    }

    public List<CarrinhoFisicoModel> listarTodos() {
        return application.listarTodos();
    }

    public Optional<CarrinhoFisicoModel> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, CarrinhoFisicoModel carrinho) {
        return application.atualizar(id, carrinho);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
