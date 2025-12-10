package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "loja")
public class LojaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLoja;

    private String nome;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    // Relação 1:N com CarrinhoFisico
    @OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
    private List<CarrinhoFisicoModel> carrinhosFisicos = new ArrayList<>();

    // Relação 1:N com Produto
    @OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
    private List<ProdutoModel> produtos = new ArrayList<>();

    public LojaModel() {}

    public LojaModel(String nome, LocalDateTime criadoEm) {
        this.nome = nome;
        this.criadoEm = criadoEm;
    }

    // Getters e Setters
    public int getIdLoja() { return idLoja; }
    public void setIdLoja(int idLoja) { this.idLoja = idLoja; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public List<CarrinhoFisicoModel> getCarrinhosFisicos() { return carrinhosFisicos; }
    public void setCarrinhosFisicos(List<CarrinhoFisicoModel> carrinhosFisicos) { this.carrinhosFisicos = carrinhosFisicos; }

    public List<ProdutoModel> getProdutos() { return produtos; }
    public void setProdutos(List<ProdutoModel> produtos) { this.produtos = produtos; }

    @Override
    public String toString() {
        return "LojaModel{" +
                "idLoja=" + idLoja +
                ", nome='" + nome + '\'' +
                ", criadoEm=" + criadoEm +
                '}';
    }
}