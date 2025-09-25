package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.application.ClienteApplication;
import br.com.carrinhoInteligente.entities.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteFacade {
    private final ClienteApplication application;

    public ClienteFacade(ClienteApplication application) {
        this.application = application;
    }

    // CREATE
    public void criarCliente(Cliente cliente) {
        application.salvarCliente(cliente);
    }

    // READ
    public List<Cliente> obterTodosClientes() {
        return application.listarClientes();
    }

    public Optional<Cliente> obterClientePorId(int id) {
        return application.buscarClientePorId(id);
    }

    // UPDATE
    public boolean editarCliente(int id, Cliente cliente) {
        return application.atualizarCliente(id, cliente);
    }

    // DELETE
    public boolean removerCliente(int id) {
        return application.deletarCliente(id);
    }
}
