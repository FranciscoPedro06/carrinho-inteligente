package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Produto;
import br.com.carrinhoInteligente.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoApplication {

    private final ProdutoRepository repository;

    public ProdutoApplication(ProdutoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public void salvar(Produto produto) {
        repository.salvar(produto);
    }

    // READ - listar todos
    public List<Produto> listarTodos() {
        return repository.listarTodos();
    }

    // READ - buscar por id
    public Optional<Produto> buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    // UPDATE
    public boolean atualizar(int id, Produto produtoAtualizado) {
        return repository.atualizar(id, produtoAtualizado);
    }

    // DELETE
    public boolean deletar(int id) {
        return repository.deletar(id);
    }

}
