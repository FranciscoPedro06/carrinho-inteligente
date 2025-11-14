package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Loja;
import br.com.carrinhoInteligente.models.LojaModel;
import br.com.carrinhoInteligente.repositories.LojaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LojaApplication {

    private final LojaRepository repository;

    public LojaApplication(LojaRepository repository) {
        this.repository = repository;
    }

    public Loja salvar(Loja loja) {
        LojaModel salvo = repository.save(loja.toModel());
        return Loja.fromModel(salvo);
    }

    public List<Loja> listarTodas() {
        return repository.findAll()
                .stream()
                .map(Loja::fromModel)
                .toList();
    }

    public Loja buscarPorId(int id) {
        return repository.findById(id)
                .map(Loja::fromModel)
                .orElse(null);
    }

    public boolean atualizar(int id, Loja loja) {
        if (repository.existsById(id)) {
            LojaModel model = loja.toModel();
            model.setIdLoja(id);
            repository.save(model);
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
