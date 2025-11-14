package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import br.com.carrinhoInteligente.models.CarrinhoItemModel;
import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import br.com.carrinhoInteligente.repositories.CarrinhoSessaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoSessaoApplication {

    private final CarrinhoSessaoRepository repository;

    public CarrinhoSessaoApplication(CarrinhoSessaoRepository repository) {
        this.repository = repository;
    }

    public CarrinhoSessao salvar(CarrinhoSessao sessao) {
        CarrinhoSessaoModel salvo = repository.save(sessao.toModel());
        return CarrinhoSessao.fromModel(salvo);
    }

    public List<CarrinhoSessao> listarTodos() {
        return repository.findAll()
                .stream()
                .map(CarrinhoSessao::fromModel)
                .toList();
    }

    public Optional<CarrinhoSessao> buscarPorId(int id) {
        return repository.findById(id)
                .map(CarrinhoSessao::fromModel);
    }

    public boolean atualizar(int id, CarrinhoSessao sessao) {
        if (!repository.existsById(id)) {
            return false;
        }

        CarrinhoSessaoModel model = sessao.toModel();
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
