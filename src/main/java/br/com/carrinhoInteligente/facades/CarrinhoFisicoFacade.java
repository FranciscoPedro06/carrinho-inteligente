package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.CarrinhoFisicoApplication;
import br.com.carrinhoInteligente.entities.CarrinhoFisico;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class CarrinhoFisicoFacade {
    private final CarrinhoFisicoApplication application;

    public CarrinhoFisicoFacade(CarrinhoFisicoApplication application) {
        this.application = application;
    }

    // CREATE
    public void salvar(CarrinhoFisico carrinho) {
        application.salvar(carrinho);
    }

    // READ
    public List<CarrinhoFisico> listarTodos() {
        return application.listarTodos();
    }

    public Optional<CarrinhoFisico> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, CarrinhoFisico carrinho) {
        return application.atualizar(id, carrinho);
    }

    // DELETE
    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
