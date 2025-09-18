package br.com.carrinhoInteligente.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CarrinhoSessao {
    private int id;
    protected long carrinhoId;
    protected long clienteId;
    protected String status;
    protected BigDecimal total;
    protected LocalDateTime criadoEm;
    protected LocalDateTime atualizadoEm;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public long getCarrinhoId() { return carrinhoId; }
    public void setCarrinhoId(long carrinhoId) { this.carrinhoId = carrinhoId; }

    public long getClienteId() { return clienteId; }
    public void setClienteId(long clienteId) { this.clienteId = clienteId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}