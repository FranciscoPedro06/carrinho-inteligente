package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estoque")
public class EstoqueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstoque;

    private int quantidade;
    private String localizacao;

    @Column(name = "id_produto")
    private int idProduto;

    // Relação 1:1 com Produto
    @OneToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "idProduto", insertable = false, updatable = false)
    private ProdutoModel produto;

    public EstoqueModel() {}

    public EstoqueModel(int quantidade, String localizacao) {
        this.quantidade = quantidade;
        this.localizacao = localizacao;
    }

    public int getIdEstoque() { return idEstoque; }
    public void setIdEstoque(int idEstoque) { this.idEstoque = idEstoque; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public ProdutoModel getProduto() { return produto; }
    public void setProduto(ProdutoModel produto) { this.produto = produto; }
}
