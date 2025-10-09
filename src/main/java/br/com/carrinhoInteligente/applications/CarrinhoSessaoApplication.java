package br.com.carrinhoInteligente.applications;

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

    public void salvar(CarrinhoSessaoModel sessao) {
        repository.save(sessao);
    }

    public List<CarrinhoSessaoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<CarrinhoSessaoModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    public boolean atualizar(int id, CarrinhoSessaoModel novaSessao) {
        if (repository.existsById(id)) {
            novaSessao.setId(id);
            repository.save(novaSessao);
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
