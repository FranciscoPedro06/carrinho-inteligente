package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.entities.CarrinhoFisico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarrinhoFisicoRepository {
    private final List<CarrinhoFisico> carrinhos = new ArrayList<>();

    // criar
    public void salvar(CarrinhoFisico carrinho) {
        carrinhos.add(carrinho);
    }

    // buscar todos
    public List<CarrinhoFisico> listarTodos() {
        return new ArrayList<>(carrinhos); // retorna cópia
    }

    // buscar por id
    public Optional<CarrinhoFisico> buscarPorId(int id) {
        return carrinhos.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }


    // atualizar
    public boolean atualizar(int id, CarrinhoFisico novoCarrinho) {
        Optional<CarrinhoFisico> existente = buscarPorId(id);
        if (existente.isPresent()) {
            CarrinhoFisico c = existente.get();
            c.setCodigoQr(novoCarrinho.getCodigoQr());
            c.setStatus(novoCarrinho.getStatus());
            c.setCriadoEm(novoCarrinho.getCriadoEm());
            return true;
        }
        return false;
    }

    // deletar
    public boolean deletar(int id) {
        return carrinhos.removeIf(c -> c.getId() == id);
    }
}
