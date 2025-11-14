package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Produto;
import br.com.carrinhoInteligente.models.ProdutoModel;
import br.com.carrinhoInteligente.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoApplication {

    private final ProdutoRepository repository;

    public ProdutoApplication(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Produto produto) {
        ProdutoModel model = produto.toModel();

        // Define a data de criação caso seja novo
        if (model.getCriadoEm() == null) {
            model.setCriadoEm(LocalDateTime.now());
        }

        repository.save(model);
    }

    public List<Produto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(Produto::fromModel)
                .toList();
    }

    public Optional<Produto> buscarPorId(int id) {
        return repository.findById(id)
                .map(Produto::fromModel);
    }

    public boolean atualizar(int id, Produto produtoAtualizado) {
        if (!repository.existsById(id)) {
            return false;
        }

        ProdutoModel model = produtoAtualizado.toModel();
        model.setIdProduto(id);

        repository.save(model);
        return true;
    }

    public boolean deletar(int id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
