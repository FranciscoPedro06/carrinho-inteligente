package br.com.carrinhoInteligente.entities;

import br.com.carrinhoInteligente.models.CarrinhoItemModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class CarrinhoItem {
    private int id;
    private int quantidade;
    private Float precoUnit;
    private Float precoTotal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime adicionadoEm;

    private int idCarrinhoSessao;
    private int idProduto;

    public CarrinhoItem(int id, int quantidade, Float precoUnit, Float precoTotal, LocalDateTime adicionadoEm,
                        int idCarrinhoSessao, int idProduto) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.precoTotal = precoTotal;
        this.adicionadoEm = adicionadoEm;
        this.idCarrinhoSessao = idCarrinhoSessao;
        this.idProduto = idProduto;
    }

    public CarrinhoItem() {}

    public CarrinhoItemModel toModel() {
        CarrinhoItemModel model = new CarrinhoItemModel();
        model.setId(this.id);
        model.setQuantidade(this.quantidade);
        model.setPrecoUnit(this.precoUnit);
        model.setPrecoTotal(this.precoTotal);
        model.setAdicionadoEm(this.adicionadoEm);
        return model;
    }

    public static CarrinhoItem fromModel(CarrinhoItemModel model) {
        return new CarrinhoItem(
                model.getId(),
                model.getQuantidade(),
                model.getPrecoUnit(),
                model.getPrecoTotal(),
                model.getAdicionadoEm(),
                model.getCarrinhoSessao() != null ? model.getCarrinhoSessao().getId() : 0,
                model.getProduto() != null ? model.getProduto().getIdProduto() : 0
        );
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