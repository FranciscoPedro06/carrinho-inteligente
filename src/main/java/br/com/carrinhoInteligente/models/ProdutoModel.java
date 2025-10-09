package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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

    public ProdutoModel() {
    }

    public ProdutoModel(String codigoBarras, String nome, Double preco, LocalDateTime criadoEm) {
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

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}
