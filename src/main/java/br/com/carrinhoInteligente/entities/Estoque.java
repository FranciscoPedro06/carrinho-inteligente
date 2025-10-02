package br.com.carrinhoInteligente.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Estoque {
    private int id;
    private int quantidade;
    private LocalDateTime criadoEm;
    private LocalDateTime expiraEm;

    public Estoque(int id, int quantidade, LocalDateTime criadoEm, LocalDateTime expiraEm) {
        this.id = id;
        this.quantidade = quantidade;
        this.criadoEm = criadoEm;
        this.expiraEm = expiraEm;
    }

    public Estoque() {

    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getExpiraEm() { return expiraEm; }
    public void setExpiraEm(LocalDateTime expiraEm) { this.expiraEm = expiraEm; }
}