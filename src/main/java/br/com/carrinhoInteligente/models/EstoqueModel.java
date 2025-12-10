package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "expira_em")
    private LocalDateTime expiraEm;

    @OneToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "idProduto", insertable = false, updatable = false)
    private ProdutoModel produto;

    public EstoqueModel() {}

    public EstoqueModel(int quantidade, String localizacao) {
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.criadoEm = LocalDateTime.now();
    }

    public int getIdEstoque() { return idEstoque; }
    public void setIdEstoque(int idEstoque) { this.idEstoque = idEstoque; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getExpiraEm() { return expiraEm; }
    public void setExpiraEm(LocalDateTime expiraEm) { this.expiraEm = expiraEm; }

    public ProdutoModel getProduto() { return produto; }
    public void setProduto(ProdutoModel produto) { this.produto = produto; }

    @Override
    public String toString() {
        return "EstoqueModel{" +
                "idEstoque=" + idEstoque +
                ", quantidade=" + quantidade +
                ", localizacao='" + localizacao + '\'' +
                ", idProduto=" + idProduto +
                ", criadoEm=" + criadoEm +
                ", expiraEm=" + expiraEm +
                '}';
    }
}