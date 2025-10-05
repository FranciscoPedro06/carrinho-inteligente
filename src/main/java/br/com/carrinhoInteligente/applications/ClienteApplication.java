package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Cliente;
import br.com.carrinhoInteligente.repositories.manual.ClienteRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteApplication {

    private final ClienteRepositoryImpl repository;

    public ClienteApplication(ClienteRepositoryImpl repository) {
        this.repository = repository;
    }

    // CREATE
    public void salvar(Cliente cliente) {
        repository.salvar(cliente);
    }

    // READ
    public List<Cliente> listarTodos() {
        return repository.listarTodos();
    }

    public Optional<Cliente> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, Cliente clienteAtualizado) {
        return repository.atualizar(id, clienteAtualizado);
    }

    // DELETE
    public boolean deletar(int id) {
        return repository.deletar(id);
    }
}
