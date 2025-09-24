package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.entities.CarrinhoItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarrinhoItemRepository {
    private final List<CarrinhoItem> itens = new ArrayList<>();

    // CREATE
    public void salvar(CarrinhoItem item) {
        itens.add(item);
    }

    // READ - listar todos
    public List<CarrinhoItem> listarTodos() {
        return new ArrayList<>(itens);
    }

    // READ - buscar por id
    public Optional<CarrinhoItem> buscarPorId(int id) {
        return itens.stream()
                .filter(i -> i.getId() == id)
                .findFirst();
    }

    // UPDATE
    public boolean atualizar(int id, CarrinhoItem novoItem) {
        Optional<CarrinhoItem> existente = buscarPorId(id);
        if (existente.isPresent()) {
            CarrinhoItem i = existente.get();
            i.setQuantidade(novoItem.getQuantidade());
            i.setPrecoUnit(novoItem.getPrecoUnit());
            i.setPrecoTotal(novoItem.getPrecoTotal());
            i.setAdicionadoEm(novoItem.getAdicionadoEm());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deletar(int id) {
        return itens.removeIf(i -> i.getId() == id);
    }
}
