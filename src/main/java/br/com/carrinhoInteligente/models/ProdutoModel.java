package br.com.carrinhoInteligente.models;

public class ProdutoModel {
    private int idProduto;
    protected String codigoBarras;
    protected String nome;
    protected Double preco;
    protected String criadoEm;

    public ProdutoModel() {}

    public ProdutoModel(int idProduto, String codigoBarras, String nome, Double preco, String criadoEm) {
        this.idProduto = idProduto;
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.preco = preco;
        this.criadoEm = criadoEm;
    }

    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public String getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(String codigoBarras) { this.codigoBarras = codigoBarras; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public String getCriadoEm() { return criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }

    @Override
    public String toString() {
        return "ProdutoModel{" +
                "idProduto=" + idProduto +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", criadoEm='" + criadoEm + '\'' +
                '}';
    }
}