package br.com.carrinhoInteligente.models;

public class ClienteModel {
    private int idCliente;
    private String nome;
    private String criadoEm;

    public ClienteModel(String nome, String criadoEm) {
        this.nome = nome;
        this.criadoEm = criadoEm;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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