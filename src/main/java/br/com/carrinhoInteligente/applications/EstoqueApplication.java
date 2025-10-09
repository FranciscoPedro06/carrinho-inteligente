package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.models.EstoqueModel;
import br.com.carrinhoInteligente.repositories.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueApplication {

    private final EstoqueRepository repository;

    public EstoqueApplication(EstoqueRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public void salvar(EstoqueModel estoque) {
        repository.save(estoque);
    }

    // READ - listar todos
    public List<EstoqueModel> listarTodos() {
        return repository.findAll();
    }

    // READ - buscar por id
    public Optional<EstoqueModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    // UPDATE
    public boolean atualizar(int id, EstoqueModel novoEstoque) {
        if (repository.existsById(id)) {
            novoEstoque.setIdEstoque(id);
            repository.save(novoEstoque);
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deletar(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
