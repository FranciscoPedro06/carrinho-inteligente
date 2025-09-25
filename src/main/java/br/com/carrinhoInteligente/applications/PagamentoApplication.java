package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Pagamento;

import java.util.List;
import java.util.Optional;

public class PagamentoApplication {

    private final PagementoRepository repository;

    public PagamentoApplication(PagementoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public void salvar(Pagamento pagamento) {
        repository.salvar(pagamento);
    }

    // READ - listar todos
    public List<Pagamento> listarTodos() {
        return repository.listarTodos();
    }

    // READ - buscar por id
    public Optional<Pagamento> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, Pagamento pagamentoAtualizado) {
        return repository.atualizar(id, pagamentoAtualizado);
    }

    // DELETE
    public boolean deletar(int id) {
        return repository.deletar(id);
    }

    private class PagementoRepository {
        public void salvar(Pagamento pagamento) {

        }

        public List<Pagamento> listarTodos() {
            return null;
        }

        public Optional<Pagamento> buscarPorId(int id) {
            return null;
        }

        public boolean atualizar(int id, Pagamento pagamentoAtualizado) {
            return false;
        }

        public boolean deletar(int id) {
            return false;
        }
    }
}
