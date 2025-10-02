package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoFisico;
import br.com.carrinhoInteligente.repositories.CarrinhoFisicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoFisicoApplication {

    private final CarrinhoFisicoRepository repository;

    public CarrinhoFisicoApplication(CarrinhoFisicoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public void salvar(CarrinhoFisico carrinho) {
        repository.salvar(carrinho);
    }

    // READ - listar todos
    public List<CarrinhoFisico> listarTodos() {
        return repository.listarTodos();
    }

    // READ - buscar por id
    public Optional<CarrinhoFisico> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, CarrinhoFisico novoCarrinho) {
        return repository.atualizar(id, novoCarrinho);
    }

    // DELETE
    public boolean deletar(int id) {
        return repository.deletar(id);
    }
}

