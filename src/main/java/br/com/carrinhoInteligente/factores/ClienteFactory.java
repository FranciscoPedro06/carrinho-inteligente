package br.com.carrinhoInteligente.factores;

import br.com.carrinhoInteligente.entities.Cliente;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ClienteFactory {

    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    // Método Factory padrão
    public static Cliente criarCliente(String nome) {
        int id = idGenerator.getAndIncrement(); // Gera um novo ID
        LocalDateTime criadoEm = LocalDateTime.now(); // Define data/hora atual
        return new Cliente(id, nome, criadoEm);
    }

    // Outro exemplo: criar cliente com data customizada
    public static Cliente criarClienteComData(String nome, LocalDateTime data) {
        int id = idGenerator.getAndIncrement();
        return new Cliente(id, nome, data);
    }
}
