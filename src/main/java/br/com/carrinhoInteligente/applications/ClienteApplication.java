package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Cliente;
import br.com.carrinhoInteligente.models.ClienteModel;
import br.com.carrinhoInteligente.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteApplication {

    private final ClienteRepository repository;

    public ClienteApplication(ClienteRepository repository) {
        this.repository = repository;
    }

    public void salvar(Cliente cliente) {
        if (cliente == null) {
            return;
        }

        ClienteModel model = cliente.toModel();
        repository.save(model);
    }

    public List<Cliente> listarTodos() {
        return repository.findAll()
                .stream()
                .map(Cliente::fromModel)
                .collect(Collectors.toList());
    }

    public Optional<Cliente> buscarPorId(int id) {
        return repository.findById(id)
                .map(Cliente::fromModel);
    }

    public boolean atualizar(int id, Cliente clienteAtualizado) {
        if (!repository.existsById(id)) {
            return false;
        }

        ClienteModel model = clienteAtualizado.toModel();
        model.setIdCliente(id);

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
