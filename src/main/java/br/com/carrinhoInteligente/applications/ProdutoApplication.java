package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Produto;

import java.util.List;
import java.util.Optional;

public class ProdutoApplication {

    private final ProdutoRpository repository;

    public ProdutoApplication(ProdutoRpository repository) {
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

    private class ProdutoRpository {
        public void salvar(Produto produto) {

        }

        public List<Produto> listarTodos() {
            return null;
        }

        public Optional<Produto> buscarPorId(int id) {
            return null;
        }

        public boolean atualizar(int id, Produto produtoAtualizado) {
            return false;
        }

        public boolean deletar(int id) {
            return false;
        }
    }
}
