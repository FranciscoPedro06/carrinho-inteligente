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

    @Column(name = "carrinho_sessao_id")
    private int idCarrinhoSessao;

    //  Relação N:1 com Sessão
    @ManyToOne
    @JoinColumn(name = "carrinho_sessao_id", referencedColumnName = "id", updatable = false, insertable = false)
    private CarrinhoSessaoModel carrinhoSessao;

    @Column(name = "id_produto")
    private int idProduto;

    //  Relação N:1 com Produto
    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "idProduto", insertable = false, updatable = false)
    private ProdutoModel produto;

    public CarrinhoItemModel() {}

    public CarrinhoItemModel(int quantidade, Float precoUnit, Float precoTotal, LocalDateTime adicionadoEm) {
        this.quantidade = quantidade;
        this.precoUnit = precoUnit;
        this.precoTotal = precoTotal;
        this.adicionadoEm = adicionadoEm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public Float getPrecoUnit() { return precoUnit; }
    public void setPrecoUnit(Float precoUnit) { this.precoUnit = precoUnit; }

    public Float getPrecoTotal() { return precoTotal; }
    public void setPrecoTotal(Float precoTotal) { this.precoTotal = precoTotal; }

    public LocalDateTime getAdicionadoEm() { return adicionadoEm; }
    public void setAdicionadoEm(LocalDateTime adicionadoEm) { this.adicionadoEm = adicionadoEm; }

    public CarrinhoSessaoModel getCarrinhoSessao() {
        return carrinhoSessao;
    }

    public void setCarrinhoSessao(CarrinhoSessaoModel carrinhoSessao) {
        this.carrinhoSessao = carrinhoSessao;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
}
