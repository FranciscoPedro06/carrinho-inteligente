package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Estoque;
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
    public void salvar(Estoque estoque) {
        repository.salvar(estoque);
    }

    // READ - listar todos
    public List<Estoque> listarTodos() {
        return repository.listarTodos();
    }

    // READ - buscar por id
    public Optional<Estoque> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, Estoque estoqueAtualizado) {
        return repository.atualizar(id, estoqueAtualizado);
    }

    // DELETE
    public boolean deletar(int id) {
        return repository.deletar(id);
    }
}
