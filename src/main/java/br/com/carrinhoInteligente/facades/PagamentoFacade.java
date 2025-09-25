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
    public void criarPagamento(Pagamento pagamento) {
        application.salvarPagamento(pagamento);
    }

    // READ
    public List<Pagamento> obterTodosPagamentos() {
        return application.listarPagamentos();
    }

    public Optional<Pagamento> obterPagamentoPorId(int id) {
        return application.buscarPagamentoPorId(id);
    }

    // UPDATE
    public boolean editarPagamento(int id, Pagamento pagamento) {
        return application.atualizarPagamento(id, pagamento);
    }

    // DELETE
    public boolean removerPagamento(int id) {
        return application.deletarPagamento(id);
    }
}
