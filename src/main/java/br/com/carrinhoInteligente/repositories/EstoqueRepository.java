package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.entities.Estoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstoqueRepository {
    private final List<Estoque> estoques = new ArrayList<>();

    // CREATE
    public void salvar(Estoque estoque) {
        estoques.add(estoque);
    }

    // READ - buscar todos
    public List<Estoque> listarTodos() {
        return new ArrayList<>(estoques);
    }

    // READ - buscar por id
    public Optional<Estoque> buscarPorId(int id) {
        return estoques.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    // UPDATE
    public boolean atualizar(int id, Estoque estoqueAtualizado) {
        Optional<Estoque> existente = buscarPorId(id);
        if (existente.isPresent()) {
            Estoque e = existente.get();
            e.setQuantidade(estoqueAtualizado.getQuantidade());
            e.setCriadoEm(estoqueAtualizado.getCriadoEm());
            e.setExpiraEm(estoqueAtualizado.getExpiraEm());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deletar(int id) {
        return estoques.removeIf(e -> e.getId() == id);
    }
}
