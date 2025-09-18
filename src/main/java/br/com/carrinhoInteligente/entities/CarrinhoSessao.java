package br.com.carrinhoInteligente.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CarrinhoSessao {
    private int id;
    private String status;
    private int total;
    private String criadoEm;
    private String atualizadoEm;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public String getCriadoEm() { return criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }

    public String getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(String atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}