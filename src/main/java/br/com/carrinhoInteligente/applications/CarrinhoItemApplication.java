package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.repositories.CarrinhoItemRepository;

import java.util.List;
import java.util.Optional;

public class CarrinhoItemApplication {

    private final CarrinhoItemRepository repository;

    public CarrinhoItemApplication(CarrinhoItemRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public void salvar(CarrinhoItem item) {
        repository.salvar(item);
    }

    // READ - listar todos
    public List<CarrinhoItem> listarTodos() {
        return repository.listarTodos();
    }

    // READ - buscar por id
    public Optional<CarrinhoItem> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, CarrinhoItem novoItem) {
        return repository.atualizar(id, novoItem);
    }

    // DELETE
    public boolean deletar(int id) {
        return repository.deletar(id);
    }
}
