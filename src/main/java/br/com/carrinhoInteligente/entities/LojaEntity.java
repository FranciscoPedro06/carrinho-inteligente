package br.com.carrinhoInteligente.entities;

public class LojaEntity {
    private int idLoja;
    private String nome;
    private String criadoEm;

    public LojaEntity(String nome, String criadoEm) {
        this.nome = nome;
        this.criadoEm = criadoEm;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }
}

