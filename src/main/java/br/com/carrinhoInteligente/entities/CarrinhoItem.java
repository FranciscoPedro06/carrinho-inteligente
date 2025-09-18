package br.com.carrinhoInteligente.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CarrinhoItem {
    private int id;
    protected long sessaoId;
    protected long produtoId;
    protected BigDecimal quantidade;
    protected BigDecimal precoUnit;
    protected BigDecimal precoTotal;
    protected LocalDateTime adicionadoEm;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public long getSessaoId() { return sessaoId; }
    public void setSessaoId(long sessaoId) { this.sessaoId = sessaoId; }

    public long getProdutoId() { return produtoId; }
    public void setProdutoId(long produtoId) { this.produtoId = produtoId; }

    public BigDecimal getQuantidade() { return quantidade; }
    public void setQuantidade(BigDecimal quantidade) { this.quantidade = quantidade; }

    public BigDecimal getPrecoUnit() { return precoUnit; }
    public void setPrecoUnit(BigDecimal precoUnit) { this.precoUnit = precoUnit; }

    public BigDecimal getPrecoTotal() { return precoTotal; }
    public void setPrecoTotal(BigDecimal precoTotal) { this.precoTotal = precoTotal; }

    public LocalDateTime getAdicionadoEm() { return adicionadoEm; }
    public void setAdicionadoEm(LocalDateTime adicionadoEm) { this.adicionadoEm = adicionadoEm; }
}