package br.com.carrinhoInteligente.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Estoque {
    private int id;
    protected long produtoId;
    protected long sessaoId;
    protected BigDecimal quantidade;
    protected LocalDateTime criadoEm;
    protected LocalDateTime expiraEm;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public long getProdutoId() { return produtoId; }
    public void setProdutoId(long produtoId) { this.produtoId = produtoId; }

    public long getSessaoId() { return sessaoId; }
    public void setSessaoId(long sessaoId) { this.sessaoId = sessaoId; }

    public BigDecimal getQuantidade() { return quantidade; }
    public void setQuantidade(BigDecimal quantidade) { this.quantidade = quantidade; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getExpiraEm() { return expiraEm; }
    public void setExpiraEm(LocalDateTime expiraEm) { this.expiraEm = expiraEm; }
}