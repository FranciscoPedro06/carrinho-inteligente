package br.com.carrinhoInteligente.application;

import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import br.com.carrinhoInteligente.factories.CarrinhoSessaoFactory;
import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import br.com.carrinhoInteligente.repositories.CarrinhoSessaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarrinhoSessaoApplication {

    private final CarrinhoSessaoRepository repository;

    public CarrinhoSessaoApplication(CarrinhoSessaoRepository repository) {
        this.repository = repository;
    }

    public CarrinhoSessao criar(CarrinhoSessao entity) {
        CarrinhoSessaoModel model = CarrinhoSessaoFactory.toModel(entity);
        CarrinhoSessaoModel salvo = repository.save(model);
        return CarrinhoSessaoFactory.toEntity(salvo);
    }

    public List<CarrinhoSessao> listar() {
        return repository.findAll()
                .stream()
                .map(CarrinhoSessaoFactory::toEntity)
                .collect(Collectors.toList());
    }

    public CarrinhoSessao buscarPorId(int id) {
        return repository.findById(id)
                .map(CarrinhoSessaoFactory::toEntity)
                .orElse(null);
    }

    public CarrinhoSessao atualizar(int id, CarrinhoSessao entity) {
        if (!repository.existsById(id)) return null;
        CarrinhoSessaoModel model = CarrinhoSessaoFactory.toModel(entity);
        model.setId(id);
        CarrinhoSessaoModel atualizado = repository.save(model);
        return CarrinhoSessaoFactory.toEntity(atualizado);
    }

    public void deletar(int id) {
        repository.deleteById(id);
    }
}
