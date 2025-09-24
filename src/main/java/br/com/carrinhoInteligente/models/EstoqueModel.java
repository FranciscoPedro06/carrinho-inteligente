package br.com.carrinhoInteligente.models;

public class EstoqueModel {
    private int id;
    protected int quantidade;
    protected String criadoEm;
    protected String expiraEm;

    public EstoqueModel() {}

    public EstoqueModel(int id, int quantidade, String criadoEm, String expiraEm) {
        this.id = id;
        this.quantidade = quantidade;
        this.criadoEm = criadoEm;
        this.expiraEm = expiraEm;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public String getCriadoEm() { return criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }

    public String getExpiraEm() { return expiraEm; }
    public void setExpiraEm(String expiraEm) { this.expiraEm = expiraEm; }

    @Override
    public String toString() {
        return "EstoqueModel{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", criadoEm='" + criadoEm + '\'' +
                ", expiraEm='" + expiraEm + '\'' +
                '}';
    }
}