package br.com.carrinhoInteligente.factores;

import br.com.carrinhoInteligente.entities.CarrinhoFisico;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class CarrinhoFisicoFactory {
    // Gerador simples de IDs automáticos
    private static final AtomicInteger idGenerator = new AtomicInteger(1);


    public static CarrinhoFisico criarCarrinho(String status) {
        int id = idGenerator.getAndIncrement();
        String codigoQr = gerarCodigoQr(); // Gera um código QR único
        LocalDateTime criadoEm = LocalDateTime.now();

        return new CarrinhoFisico(id, codigoQr, status, criadoEm);
    }


    public static CarrinhoFisico criarCarrinhoComQr(String status, String codigoQr) {
        int id = idGenerator.getAndIncrement();
        LocalDateTime criadoEm = LocalDateTime.now();

        return new CarrinhoFisico(id, codigoQr, status, criadoEm);
    }

    //Método auxiliar para gerar QR codes aleatórios (simulados).//

    private static String gerarCodigoQr() {
        return "QR-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
