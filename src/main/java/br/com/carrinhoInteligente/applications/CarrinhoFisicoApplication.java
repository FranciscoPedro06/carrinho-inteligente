package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoFisico;
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

    public CarrinhoFisico salvar(CarrinhoFisico carrinho) {
        CarrinhoFisicoModel salvo = repository.save(carrinho.toModel());
        return CarrinhoFisico.fromModel(salvo);
    }

    public List<CarrinhoFisico> listarTodos() {
        return repository.findAll()
                .stream()
                .map(CarrinhoFisico::fromModel)
                .toList();
    }

    public Optional<CarrinhoFisico> buscarPorId(int id) {
        return repository.findById(id)
                .map(CarrinhoFisico::fromModel);
    }

    public boolean atualizar(int id, CarrinhoFisico novoCarrinho) {
        if (!repository.existsById(id)) {
            return false;
        }

        CarrinhoFisicoModel model = novoCarrinho.toModel();
        model.setId(id);

        repository.save(model);
        return true;
    }

    public boolean deletar(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
