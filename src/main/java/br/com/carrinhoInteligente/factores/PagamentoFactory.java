package br.com.carrinhoInteligente.factores;

import br.com.carrinhoInteligente.entities.Pagamento;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class PagamentoFactory {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);


    public static Pagamento criarPagamento(String metodo, Double valor) {
        int id = idGenerator.getAndIncrement();
        LocalDateTime agora = LocalDateTime.now();

        return new Pagamento(id, metodo, valor, "PENDENTE", agora, agora);
    }


    public static Pagamento criarPagamentoComStatus(String metodo, Double valor, String status) {
        int id = idGenerator.getAndIncrement();
        LocalDateTime agora = LocalDateTime.now();

        return new Pagamento(id, metodo, valor, status, agora, agora);
    }

    public static Pagamento atualizarStatus(Pagamento pagamento, String novoStatus) {
        pagamento.setStatus(novoStatus);
        pagamento.setAtualizadoEm(LocalDateTime.now());
        return pagamento;
    }
}
