package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Estoque;
import br.com.carrinhoInteligente.models.EstoqueModel;
import br.com.carrinhoInteligente.repositories.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstoqueApplication {

    private final EstoqueRepository repository;

    public EstoqueApplication(EstoqueRepository repository) {
        this.repository = repository;
    }

    public void salvar(Estoque estoque) {

        if (estoque == null) {
            return;
        }

        EstoqueModel model = estoque.toModel();
        repository.save(model);
    }

    public List<Estoque> listarTodos() {
        return repository.findAll()
                .stream()
                .map(Estoque::fromModel)
                .collect(Collectors.toList());
    }

    public Optional<Estoque> buscarPorId(int id) {
        return repository.findById(id)
                .map(Estoque::fromModel);
    }

    public boolean atualizar(int id, Estoque estoqueAtualizado) {

        if (!repository.existsById(id)) {
            return false;
        }

        EstoqueModel model = estoqueAtualizado.toModel();
        model.setIdEstoque(id);

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
