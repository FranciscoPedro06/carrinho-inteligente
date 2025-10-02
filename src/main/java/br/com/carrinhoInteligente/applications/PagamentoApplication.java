package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Pagamento;
import br.com.carrinhoInteligente.repositories.PagamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class PagamentoApplication {

    private final PagamentoRepository repository;

    public PagamentoApplication(PagamentoRepository repository) {
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


}
