package br.com.carrinhoInteligente.entities;

public class ClienteEntity {
    private int idCliente;
    private String nome;
    private String criadoEm;

    public ClienteEntity(String nome, String criadoEm) {
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
