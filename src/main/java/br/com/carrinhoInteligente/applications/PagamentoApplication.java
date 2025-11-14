package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.entities.Pagamento;
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

    public Pagamento salvar(Pagamento pagamento) {
        PagamentoModel salvo = repository.save(pagamento.toModel());
        return Pagamento.fromModel(salvo);
    }

    public List<Pagamento> listarTodos() {
        return repository.findAll()
                .stream()
                .map(Pagamento::fromModel)
                .toList();
    }

    public Optional<Pagamento> buscarPorId(int id) {
        return repository.findById(id)
                .map(Pagamento::fromModel);
    }

    public boolean atualizar(int id, Pagamento pagamento) {

        if (!repository.existsById(id)) {
            return false;
        }

        PagamentoModel model = pagamento.toModel();
        model.setId(id);

        repository.save(model);
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
