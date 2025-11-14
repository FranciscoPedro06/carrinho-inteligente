package br.com.carrinhoInteligente.entities;

import br.com.carrinhoInteligente.models.ProdutoModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Produto {

    private int idProduto;
    private String codigoBarras;
    private String nome;
    private Double preco;
    private int idLoja;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime criadoEm;

    public Produto() {}

    public Produto(int idProduto, String codigoBarras, String nome, Double preco,
                   int idLoja, LocalDateTime criadoEm) {
        this.idProduto = idProduto;
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.preco = preco;
        this.idLoja = idLoja;
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

    public int getIdLoja() { return idLoja; }
    public void setIdLoja(int idLoja) { this.idLoja = idLoja; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public ProdutoModel toModel() {
        ProdutoModel model = new ProdutoModel();
        model.setIdProduto(this.idProduto);
        model.setCodigoBarras(this.codigoBarras);
        model.setNome(this.nome);
        model.setPreco(this.preco);
        model.setIdLoja(this.idLoja);
        model.setCriadoEm(this.criadoEm);
        return model;
    }

    public static Produto fromModel(ProdutoModel model) {
        return new Produto(
                model.getIdProduto(),
                model.getCodigoBarras(),
                model.getNome(),
                model.getPreco(),
                model.getIdLoja(),
                model.getCriadoEm()
        );
    }
}
