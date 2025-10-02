package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Loja;
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

    // CREATE
    public void salvar(Loja loja) {
        repository.salvar(loja);
    }

    // READ - listar todas
    public List<Loja> listarTodas() {
        return repository.listarTodas();
    }

    // READ - buscar por id
    public Optional<Loja> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, Loja lojaAtualizada) {
        return repository.atualizar(id, lojaAtualizada);
    }

    // DELETE
    public boolean deletar(int id) {
        return repository.deletar(id);
    }
}
