package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.application.PagamentoApplication;
import br.com.carrinhoInteligente.entities.Pagamento;

import java.util.List;
import java.util.Optional;

public class PagamentoFacade {
    private final PagamentoApplication application;

    public PagamentoFacade(PagamentoApplication application) {
        this.application = application;
    }

    // CREATE
    public void salvar(Pagamento pagamento) {
        application.salvarPagamento(pagamento);
    }

    // READ
    public List<Pagamento> listarTodos() {
        return application.listarPagamentos();
    }

    public Optional<Pagamento> buscarPorId(int id) {
        return application.buscarPagamentoPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, Pagamento pagamento) {
        return application.atualizarPagamento(id, pagamento);
    }

    // DELETE
    public boolean deletar(int id) {
        return application.deletarPagamento(id);
    }
}
