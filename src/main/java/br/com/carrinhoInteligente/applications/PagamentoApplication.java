package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.models.PagamentoModel;
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

    public void salvar(PagamentoModel pagamento) {
        repository.save(pagamento);
    }

    public List<PagamentoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<PagamentoModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    public boolean atualizar(int id, PagamentoModel pagamentoAtualizado) {
        if (repository.existsById(id)) {
            pagamentoAtualizado.setId(id);
            repository.save(pagamentoAtualizado);
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
