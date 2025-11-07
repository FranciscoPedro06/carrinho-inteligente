package br.com.carrinhoInteligente.application;

import br.com.carrinhoInteligente.entities.Cliente;
import br.com.carrinhoInteligente.factories.ClienteFactory;
import br.com.carrinhoInteligente.models.ClienteModel;
import br.com.carrinhoInteligente.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteApplication {

    private final ClienteRepository repository;

    public ClienteApplication(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente criar(Cliente entity) {
        ClienteModel model = ClienteFactory.toModel(entity);
        ClienteModel salvo = repository.save(model);
        return ClienteFactory.toEntity(salvo);
    }

    public List<Cliente> listar() {
        return repository.findAll()
                .stream()
                .map(ClienteFactory::toEntity)
                .collect(Collectors.toList());
    }

    public Cliente buscarPorId(int id) {
        return repository.findById(id)
                .map(ClienteFactory::toEntity)
                .orElse(null);
    }

    public Cliente atualizar(int id, Cliente entity) {
        if (!repository.existsById(id)) return null;
        ClienteModel model = ClienteFactory.toModel(entity);
        model.setIdCliente(id);
        ClienteModel atualizado = repository.save(model);
        return ClienteFactory.toEntity(atualizado);
    }

    public void deletar(int id) {
        repository.deleteById(id);
    }
}
