package br.com.carrinhoInteligente.factores;

import br.com.carrinhoInteligente.entities.Produto;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class ProdutoFactory {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);


    public static Produto criarProduto(String nome, Double preco) {
        int id = idGenerator.getAndIncrement();
        String codigoBarras = gerarCodigoBarras();
        LocalDateTime criadoEm = LocalDateTime.now();

        return new Produto(id, codigoBarras, nome, preco, criadoEm);
    }


    public static Produto criarProdutoComCodigo(String nome, Double preco, String codigoBarras) {
        int id = idGenerator.getAndIncrement();
        LocalDateTime criadoEm = LocalDateTime.now();

        return new Produto(id, codigoBarras, nome, preco, criadoEm);
    }

    private static String gerarCodigoBarras() {
        return "PROD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
