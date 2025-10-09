package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.models.ClienteModel;
import br.com.carrinhoInteligente.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteApplication {

    private final ClienteRepository repository;

    public ClienteApplication(ClienteRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public void salvar(ClienteModel cliente) {
        repository.save(cliente);
    }

    // READ - listar todos
    public List<ClienteModel> listarTodos() {
        return repository.findAll();
    }

    // READ - buscar por id
    public Optional<ClienteModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    // UPDATE
    public boolean atualizar(int id, ClienteModel novoCliente) {
        if (repository.existsById(id)) {
            novoCliente.setIdCliente(id);
            repository.save(novoCliente);
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
