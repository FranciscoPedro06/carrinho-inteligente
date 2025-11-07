package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.factories.CarrinhoItemFactory;
import br.com.carrinhoInteligente.models.CarrinhoItemModel;
import br.com.carrinhoInteligente.repositories.CarrinhoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarrinhoItemApplication {

    private final CarrinhoItemRepository repository;

    public CarrinhoItemApplication(CarrinhoItemRepository repository) {
        this.repository = repository;
    }

    public CarrinhoItem salvar(CarrinhoItem item) {
        CarrinhoItemModel model = CarrinhoItemFactory.toModel(item);
        return CarrinhoItemFactory.toEntity(repository.save(model));
    }

    public List<CarrinhoItem> listarTodos() {
        return repository.findAll()
                .stream()
                .map(CarrinhoItemFactory::toEntity)
                .collect(Collectors.toList());
    }

    public Optional<CarrinhoItem> buscarPorId(int id) {
        return repository.findById(id)
                .map(CarrinhoItemFactory::toEntity);
    }

    public boolean atualizar(int id, CarrinhoItem novoItem) {
        if (repository.existsById(id)) {
            novoItem.setId(id);
            repository.save(CarrinhoItemFactory.toModel(novoItem));
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
