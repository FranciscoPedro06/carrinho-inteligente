package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.entities.Loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LojaRepository {
    private final List<Loja> lojas = new ArrayList<>();

    // CREATE
    public void salvar(Loja loja) {
        lojas.add(loja);
    }

    // READ - listar todas
    public List<Loja> listarTodas() {
        return new ArrayList<>(lojas);
    }

    // READ - buscar por id
    public Optional<Loja> buscarPorId(int id) {
        return lojas.stream()
                .filter(l -> l.getIdLoja() == id)
                .findFirst();
    }

    // UPDATE
    public boolean atualizar(int id, Loja lojaAtualizada) {
        Optional<Loja> existente = buscarPorId(id);
        if (existente.isPresent()) {
            Loja l = existente.get();
            l.setNome(lojaAtualizada.getNome());
            l.setCriadoEm(lojaAtualizada.getCriadoEm());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deletar(int id) {
        return lojas.removeIf(l -> l.getIdLoja() == id);
    }
}
