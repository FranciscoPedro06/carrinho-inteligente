package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    private String nome;
    private Double preco;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    // Relação N:1 com Loja
    @ManyToOne
    @JoinColumn(name = "id_loja", referencedColumnName = "idLoja")
    private LojaModel loja;

    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
    private EstoqueModel estoque;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<CarrinhoItemModel> itens = new ArrayList<>();

    public ProdutoModel() {}

    public ProdutoModel(String codigoBarras, String nome, Double preco, LocalDateTime criadoEm) {
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.preco = preco;
        this.criadoEm = criadoEm;
    }

    // Getters e Setters
    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public String getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(String codigoBarras) { this.codigoBarras = codigoBarras; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LojaModel getLoja() { return loja; }
    public void setLoja(LojaModel loja) { this.loja = loja; }

    // Método auxiliar para obter ID da loja
    public int getIdLoja() {
        return loja != null ? loja.getIdLoja() : 0;
    }

    public EstoqueModel getEstoque() { return estoque; }
    public void setEstoque(EstoqueModel estoque) { this.estoque = estoque; }

    public List<CarrinhoItemModel> getItens() { return itens; }
    public void setItens(List<CarrinhoItemModel> itens) { this.itens = itens; }

    @Override
    public String toString() {
        return "ProdutoModel{" +
                "idProduto=" + idProduto +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", criadoEm=" + criadoEm +
                ", loja=" + (loja != null ? loja.getIdLoja() : "null") +
                '}';
    }
}