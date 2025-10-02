package br.com.carrinhoInteligente.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CarrinhoSessao {
    private int id;
    private String status;
    private int total;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public CarrinhoSessao(int id, String status, int total, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.id = id;
        this.status = status;
        this.total = total;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public CarrinhoSessao() {

    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}