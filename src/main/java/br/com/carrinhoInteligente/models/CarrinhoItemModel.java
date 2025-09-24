package br.com.carrinhoInteligente.models;

public class CarrinhoItemModel {
    private int id;
    protected int quantidade;
    protected Float precoUnit;
    protected Float precoTotal;
    protected String adicionadoEm;

    public CarrinhoItemModel() {}

    public CarrinhoItemModel(int id, int quantidade, Float precoUnit, Float precoTotal, String adicionadoEm) {
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

    public String getAdicionadoEm() { return adicionadoEm; }
    public void setAdicionadoEm(String adicionadoEm) { this.adicionadoEm = adicionadoEm; }

    @Override
    public String toString() {
        return "CarrinhoItemModel{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", precoUnit=" + precoUnit +
                ", precoTotal=" + precoTotal +
                ", adicionadoEm='" + adicionadoEm + '\'' +
                '}';
    }
}