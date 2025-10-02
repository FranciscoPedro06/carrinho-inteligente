package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarrinhoSessaoRepository {
    private final List<CarrinhoSessao> sessoes = new ArrayList<>();

    // CREATE
    public void salvar(CarrinhoSessao sessao) {
        sessoes.add(sessao);
    }

    // READ - listar todos
    public List<CarrinhoSessao> listarTodos() {
        return new ArrayList<>(sessoes);
    }

    // READ - buscar por id
    public Optional<CarrinhoSessao> buscarPorId(int id) {
        return sessoes.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    // UPDATE
    public boolean atualizar(int id, CarrinhoSessao novaSessao) {
        Optional<CarrinhoSessao> existente = buscarPorId(id);
        if (existente.isPresent()) {
            CarrinhoSessao s = existente.get();
            s.setStatus(novaSessao.getStatus());
            s.setTotal(novaSessao.getTotal());
            s.setCriadoEm(novaSessao.getCriadoEm());
            s.setAtualizadoEm(novaSessao.getAtualizadoEm());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deletar(int id) {
        return sessoes.removeIf(s -> s.getId() == id);
    }
}
