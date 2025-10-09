package br.com.carrinhoInteligente.applications;

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

    public void salvar(LojaModel loja) {
        repository.save(loja);
    }

    public List<LojaModel> listarTodas() {
        return repository.findAll();
    }

    public Optional<LojaModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    public boolean atualizar(int id, LojaModel lojaAtualizada) {
        if (repository.existsById(id)) {
            lojaAtualizada.setIdLoja(id);
            repository.save(lojaAtualizada);
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
