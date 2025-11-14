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

    public PagamentoModel salvar(PagamentoModel pagamento) {
        if (pagamento == null) {
            return null;
        }
        return repository.save(pagamento);
    }

    public List<PagamentoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<PagamentoModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    public boolean atualizar(int id, PagamentoModel pagamentoAtualizado) {

        if (pagamentoAtualizado == null) {
            return false;
        }

        Optional<PagamentoModel> existente = repository.findById(id);

        if (!existente.isPresent()) {
            return false;
        }

        PagamentoModel pagamento = existente.get();

        pagamento.setMetodo(pagamentoAtualizado.getMetodo());
        pagamento.setValor(pagamentoAtualizado.getValor());
        pagamento.setStatus(pagamentoAtualizado.getStatus());
        pagamento.setAtualizadoEm(pagamentoAtualizado.getAtualizadoEm());

        repository.save(pagamento);
        return true;
    }

    public boolean deletar(int id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
