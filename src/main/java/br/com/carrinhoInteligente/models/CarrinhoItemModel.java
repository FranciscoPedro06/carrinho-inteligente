package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "carrinho_item")
public class CarrinhoItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantidade;

    @Column(name = "preco_unit")
    private Float precoUnit;

    @Column(name = "preco_total")
    private Float precoTotal;

    @Column(name = "adicionado_em")
    private LocalDateTime adicionadoEm;

    public CarrinhoItemModel() {
    }

    public CarrinhoItemModel(int id, int quantidade, Float precoUnit, Float precoTotal, LocalDateTime adicionadoEm) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.precoTotal = precoTotal;
        this.adicionadoEm = adicionadoEm;
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
}
