package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.entities.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();

    // CREATE
    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    // READ - buscar todos
    public List<Cliente> listarTodos(){
        return new ArrayList<>(clientes);
    }

    // READ - buscar por id
    public Optional<Cliente> buscarPorId(int id){
        return clientes.stream()
                .filter(c -> c.getIdCliente() == id)
                .findFirst();
    }

    // UPDATE
    public boolean atualizar(int id, Cliente cliente){
        Optional<Cliente> existente = buscarPorId(id);
        if(existente.isPresent()){
            Cliente c = existente.get();
            c.setNome(cliente.getNome());
            c.setCriadoEm(cliente.getCriadoEm());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deletar(int id){
    return  clientes.removeIf(c -> c.getIdCliente() == id);
    }
}


