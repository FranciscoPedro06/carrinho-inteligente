package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.PagamentoApplication;
import br.com.carrinhoInteligente.entities.Pagamento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PagamentoFacade {

    private final PagamentoApplication application;

    public PagamentoFacade(PagamentoApplication application) {
        this.application = application;
    }

    public Pagamento salvar(Pagamento pagamento) {
        return application.salvar(pagamento);
    }

    public List<Pagamento> listarTodos() {
        return application.listarTodos();
    }

    public Optional<Pagamento> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, Pagamento pagamento) {
        return application.atualizar(id, pagamento);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}