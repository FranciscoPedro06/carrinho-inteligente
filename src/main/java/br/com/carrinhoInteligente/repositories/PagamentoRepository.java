package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.entities.Pagamento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PagamentoRepository {
    private final List<Pagamento> pagamentos = new ArrayList<>();

    // CREATE
    public void salvar(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    // READ - listar todos
    public List<Pagamento> listarTodos() {
        return new ArrayList<>(pagamentos);
    }

    // READ - buscar por id
    public Optional<Pagamento> buscarPorId(int id) {
        return pagamentos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    // UPDATE
    public boolean atualizar(int id, Pagamento pagamentoAtualizado) {
        Optional<Pagamento> existente = buscarPorId(id);
        if (existente.isPresent()) {
            Pagamento p = existente.get();
            p.setMetodo(pagamentoAtualizado.getMetodo());
            p.setValor(pagamentoAtualizado.getValor());
            p.setStatus(pagamentoAtualizado.getStatus());
            p.setCriadoEm(pagamentoAtualizado.getCriadoEm());
            p.setAtualizadoEm(pagamentoAtualizado.getAtualizadoEm());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deletar(int id) {
        return pagamentos.removeIf(p -> p.getId() == id);
    }
}
