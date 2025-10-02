package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.entities.CarrinhoFisico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarrinhoFisicoRepository {
    private final List<CarrinhoFisico> carrinhos = new ArrayList<>();

    // CREATE
    public void salvar(CarrinhoFisico carrinho) {
        carrinhos.add(carrinho);
    }

    // READ - buscar todos
    public List<CarrinhoFisico> listarTodos() {
        return new ArrayList<>(carrinhos); 
    }

    // READ - buscar por id
    public Optional<CarrinhoFisico> buscarPorId(int id) {
        return carrinhos.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }


    // UPDATE
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

    // DELETE
    public boolean deletar(int id) {
        return carrinhos.removeIf(c -> c.getId() == id);
    }
}
