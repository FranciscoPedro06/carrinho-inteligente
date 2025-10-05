package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
import br.com.carrinhoInteligente.repositories.CarrinhoFisicoRepository;
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
    public void salvar(CarrinhoFisicoModel carrinho) {
        repository.save(carrinho);
    }

    // READ - listar todos
    public List<CarrinhoFisicoModel> listarTodos() {
        return repository.findAll();
    }

    // READ - buscar por id
    public Optional<CarrinhoFisicoModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    // UPDATE
    public boolean atualizar(int id, CarrinhoFisicoModel novoCarrinho) {
        if (repository.existsById(id)) {
            novoCarrinho.setId(id);
            repository.save(novoCarrinho);
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
