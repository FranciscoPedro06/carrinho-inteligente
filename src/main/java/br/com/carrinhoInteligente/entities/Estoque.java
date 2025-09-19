package br.com.carrinhoInteligente.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Estoque {
    private int id;
    private int quantidade;
    private String criadoEm;
    private String expiraEm;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public String getCriadoEm() { return criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }

    public String getExpiraEm() { return expiraEm; }
    public void setExpiraEm(String expiraEm) { this.expiraEm = expiraEm; }
}