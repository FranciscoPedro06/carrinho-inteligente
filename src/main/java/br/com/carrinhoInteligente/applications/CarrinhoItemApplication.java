package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoFisico;
import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
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

    public CarrinhoItem salvar(CarrinhoItem item) {
        CarrinhoItemModel salvo = repository.save(item.toModel());
        return CarrinhoItem.fromModel(salvo);
    }

    public List<CarrinhoItem> listarTodos() {
        return repository.findAll()
                .stream()
                .map(CarrinhoItem::fromModel)
                .toList();
    }

    public Optional<CarrinhoItem> buscarPorId(int id) {
        return repository.findById(id)
                .map(CarrinhoItem::fromModel);
    }

    public boolean atualizar(int id, CarrinhoItem novoCarrinhoItem) {
        if (!repository.existsById(id)) {
            return false;
        }

        CarrinhoItemModel model = novoCarrinhoItem.toModel();
        model.setId(id);

        repository.save(model);
        return true;
    }

    public boolean deletar(int id) {
        if (!repository.existsById(id)) return false;

        repository.deleteById(id);
        return true;
    }
}
