package br.com.carrinhoInteligente.models;

public class LojaModel {
    private int idLoja;
    protected String nome;
    protected String criadoEm;

    public LojaModel() {}

    public LojaModel(int idLoja, String nome, String criadoEm) {
        this.idLoja = idLoja;
        this.nome = nome;
        this.criadoEm = criadoEm;
    }

    public int getIdLoja() { return idLoja; }
    public void setIdLoja(int idLoja) { this.idLoja = idLoja; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCriadoEm() { return criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }

    @Override
    public String toString() {
        return "LojaModel{" +
                "idLoja=" + idLoja +
                ", nome='" + nome + '\'' +
                ", criadoEm='" + criadoEm + '\'' +
                '}';
    }
}