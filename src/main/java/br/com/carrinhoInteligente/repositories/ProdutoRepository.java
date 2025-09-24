package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.entities.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();

    // CREATE
    public void salvar(Produto produto) {
        produtos.add(produto);
    }

    // READ - listar todos
    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    // READ - buscar por id
    public Optional<Produto> buscarPorId(int id) {
        return produtos.stream()
                .filter(p -> p.getIdProduto() == id)
                .findFirst();
    }

    // UPDATE
    public boolean atualizar(int id, Produto produtoAtualizado) {
        Optional<Produto> existente = buscarPorId(id);
        if (existente.isPresent()) {
            Produto p = existente.get();
            p.setCodigoBarras(produtoAtualizado.getCodigoBarras());
            p.setNome(produtoAtualizado.getNome());
            p.setPreco(produtoAtualizado.getPreco());
            p.setCriadoEm(produtoAtualizado.getCriadoEm());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deletar(int id) {
        return produtos.removeIf(p -> p.getIdProduto() == id);
    }
}
