package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.ClienteApplication;
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

    public void salvar(ClienteModel cliente) {
        application.salvar(cliente);
    }

    public List<ClienteModel> listarTodos() {
        return application.listarTodos();
    }

    public Optional<ClienteModel> buscarPorId(int id) {
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, ClienteModel cliente) {
        return application.atualizar(id, cliente);
    }

    public boolean deletar(int id) {
        return application.deletar(id);
    }
}
