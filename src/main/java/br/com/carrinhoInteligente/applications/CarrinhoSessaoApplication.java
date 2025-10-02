package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoSessao;
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

    // CREATE
    public void salvar(CarrinhoSessao sessao) {
        repository.salvar(sessao);
    }

    // READ - listar todos
    public List<CarrinhoSessao> listarTodos() {
        return repository.listarTodos();
    }

    // READ - buscar por id
    public Optional<CarrinhoSessao> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, CarrinhoSessao novaSessao) {
        return repository.atualizar(id, novaSessao);
    }

    // DELETE
    public boolean deletar(int id) {
        return repository.deletar(id);
    }
}
