package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.models.ProdutoModel;
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

    public void salvar(ProdutoModel produto) {
        repository.save(produto);
    }

    public List<ProdutoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    public boolean atualizar(int id, ProdutoModel produtoAtualizado) {
        if (repository.existsById(id)) {
            produtoAtualizado.setIdProduto(id);
            repository.save(produtoAtualizado);
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
