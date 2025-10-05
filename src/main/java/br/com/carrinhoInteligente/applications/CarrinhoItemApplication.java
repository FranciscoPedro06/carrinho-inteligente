package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.models.CarrinhoItemModel;
import br.com.carrinhoInteligente.repositories.CarrinhoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoItemApplication {

    private final CarrinhoItemRepository repository;

    public CarrinhoItemApplication(CarrinhoItemRepository repository) {
        this.repository = repository;
    }

    public void salvar(CarrinhoItemModel item) {
        repository.save(item);
    }

    public List<CarrinhoItemModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<CarrinhoItemModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    public boolean atualizar(int id, CarrinhoItemModel novoItem) {
        if (repository.existsById(id)) {
            novoItem.setId(id);
            repository.save(novoItem);
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
