package br.com.carrinhoInteligente.models;

public class ClienteModel {
    private int idCliente;
    protected String nome;
    protected String criadoEm;

    public ClienteModel() {}

    public ClienteModel(int idCliente, String nome, String criadoEm) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.criadoEm = criadoEm;
    }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCriadoEm() { return criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", criadoEm='" + criadoEm + '\'' +
                '}';
    }
}