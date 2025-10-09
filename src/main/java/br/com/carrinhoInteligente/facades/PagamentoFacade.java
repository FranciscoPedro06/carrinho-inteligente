package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.PagamentoApplication;
import br.com.carrinhoInteligente.models.PagamentoModel;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class PagamentoFacade {
    private final PagamentoApplication application;

    public PagamentoFacade(PagamentoApplication application) {
        this.application = application;
    }

    public void salvar(PagamentoModel pagamento) {
        application.salvar(pagamento);
    }

    public List<PagamentoModel> listarTodos() {
        return application.listarTodos();
    }

    public Optional<PagamentoModel> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, PagamentoModel pagamento) {
        return application.atualizar(id, pagamento);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
