package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.application.LojaApplication;
import br.com.carrinhoInteligente.entities.Loja;

import java.util.List;
import java.util.Optional;

public class LojaFacade {
    private final LojaApplication application;

    public LojaFacade(LojaApplication application) {
        this.application = application;
    }

    // CREATE
    public void criarLoja(Loja loja) {
        application.salvarLoja(loja);
    }

    // READ
    public List<Loja> obterTodasLojas() {
        return application.listarLojas();
    }

    public Optional<Loja> obterLojaPorId(int id) {
        return application.buscarLojaPorId(id);
    }

    // UPDATE
    public boolean editarLoja(int id, Loja loja) {
        return application.atualizarLoja(id, loja);
    }

    // DELETE
    public boolean removerLoja(int id) {
        return application.deletarLoja(id);
    }
}
