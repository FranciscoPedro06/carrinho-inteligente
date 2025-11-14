package br.com.carrinhoInteligente.entities;

import br.com.carrinhoInteligente.models.CarrinhoItemModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int idProduto;
    private String codigoBarras;
    private String nome;
    private Double preco;
    private int idLoja;
    private List<CarrinhoItemModel> itens = new ArrayList<>();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime criadoEm;

    public Produto(int idProduto, String codigoBarras, String nome, Double preco, LocalDateTime criadoEm) {
        this.idProduto = idProduto;
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.preco = preco;
        this.criadoEm = criadoEm;
    }
    public Produto() {}

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
