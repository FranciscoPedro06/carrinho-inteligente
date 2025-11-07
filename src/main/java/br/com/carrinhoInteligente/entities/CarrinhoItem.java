package br.com.carrinhoInteligente.entities;

import java.time.LocalDateTime;

public class CarrinhoItem {

    private int id;
    private int quantidade;
    private Float precoUnit;
    private Float precoTotal;
    private LocalDateTime adicionadoEm;
    private int idCarrinhoSessao;
    private int idProduto;

    public CarrinhoItem() {}

    public CarrinhoItem(
            int id,
            int quantidade,
            Float precoUnit,
            Float precoTotal,
            LocalDateTime adicionadoEm,
            int idCarrinhoSessao,
            int idProduto
    ) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.precoTotal = precoTotal;
        this.adicionadoEm = adicionadoEm;
        this.idCarrinhoSessao = idCarrinhoSessao;
        this.idProduto = idProduto;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public Float getPrecoUnit() { return precoUnit; }
    public void setPrecoUnit(Float precoUnit) { this.precoUnit = precoUnit; }

    public Float getPrecoTotal() { return precoTotal; }
    public void setPrecoTotal(Float precoTotal) { this.precoTotal = precoTotal; }

    public LocalDateTime getAdicionadoEm() { return adicionadoEm; }
    public void setAdicionadoEm(LocalDateTime adicionadoEm) { this.adicionadoEm = adicionadoEm; }

    public int getIdCarrinhoSessao() { return idCarrinhoSessao; }
    public void setIdCarrinhoSessao(int idCarrinhoSessao) { this.idCarrinhoSessao = idCarrinhoSessao; }

    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }
}
