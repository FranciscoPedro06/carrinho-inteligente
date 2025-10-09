package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estoque")
public class EstoqueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstoque;

    private String produto;
    private int quantidade;
    private String localizacao;

    public EstoqueModel() {
    }

    public EstoqueModel(int idEstoque, String produto, int quantidade, String localizacao) {
        this.idEstoque = idEstoque;
        this.produto = produto;
        this.quantidade = quantidade;
        this.localizacao = localizacao;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "EstoqueModel{" +
                "idEstoque=" + idEstoque +
                ", produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
