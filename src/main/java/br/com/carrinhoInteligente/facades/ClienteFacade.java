package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.ClienteApplication;
import br.com.carrinhoInteligente.entities.Cliente;
import br.com.carrinhoInteligente.models.ClienteModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteFacade {
    private final ClienteApplication application;

    public ClienteFacade(ClienteApplication application) {
        this.application = application;
    }

    public void salvar(ClienteModel clienteModel) {
        Cliente cliente = Cliente.fromModel(clienteModel);
        application.salvar(cliente);
    }

    public List<Cliente> listarTodos() {
        return application.listarTodos();
    }

    public Optional<Cliente> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, ClienteModel clienteModel) {
        Cliente cliente = Cliente.fromModel(clienteModel);
        return application.atualizar(id, cliente);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
