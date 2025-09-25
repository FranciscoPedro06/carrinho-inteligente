package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Cliente;
import br.com.carrinhoInteligente.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

public class ClienteApplication {

    private final ClienteRepository repository;

    public ClienteApplication(ClienteRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public void salvar(Cliente cliente) {
        repository.salvar(cliente);
    }

    // READ - listar todos
    public List<Cliente> listarTodos() {
        return repository.listarTodos();
    }

    // READ - buscar por id
    public Optional<Cliente> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, Cliente cliente) {
        return repository.atualizar(id, cliente);
    }

    // DELETE
    public boolean deletar(int id) {
        return repository.deletar(id);
    }
}
