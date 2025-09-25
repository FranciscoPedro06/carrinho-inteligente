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
    public void salvar(Cliente cliente) {
        application.salvarCliente(cliente);
    }

    // READ
    public List<Cliente> listarTodos() {
        return application.listarClientes();
    }

    public Optional<Cliente> buscarPorId(int id) {
        return application.buscarClientePorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, Cliente cliente) {
        return application.atualizarCliente(id, cliente);
    }

    // DELETE
    public boolean deletar(int id) {
        return application.deletarCliente(id);
    }
}
