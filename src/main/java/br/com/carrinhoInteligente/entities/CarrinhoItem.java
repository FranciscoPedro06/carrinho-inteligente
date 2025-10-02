package br.com.carrinhoInteligente.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class CarrinhoItem {
    private int id;
    private int quantidade;
    private Float precoUnit;
    private Float precoTotal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime adicionadoEm;

    public CarrinhoItem(int id, int quantidade, Float precoUnit, Float precoTotal, LocalDateTime adicionadoEm) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.precoTotal = precoTotal;
        this.adicionadoEm = adicionadoEm;
    }
    public CarrinhoItem() {}

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
