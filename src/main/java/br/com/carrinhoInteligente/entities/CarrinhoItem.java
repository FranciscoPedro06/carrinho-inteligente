package br.com.carrinhoInteligente.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CarrinhoItem {
    private int id;
    private int quantidade;
    private Float precoUnit;
    private Float precoTotal;
    private String adicionadoEm;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public Float getPrecoUnit() { return precoUnit; }
    public void setPrecoUnit(Float precoUnit) { this.precoUnit = precoUnit; }

    public Float getPrecoTotal() { return precoTotal; }
    public void setPrecoTotal(Float precoTotal) { this.precoTotal = precoTotal; }

    public String getAdicionadoEm() { return adicionadoEm; }
    public void setAdicionadoEm(String adicionadoEm) { this.adicionadoEm = adicionadoEm; }
}