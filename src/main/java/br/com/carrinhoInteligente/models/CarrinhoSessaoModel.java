package br.com.carrinhoInteligente.models;

public class CarrinhoSessaoModel {
    private int id;
    protected String status;
    protected int total;
    protected String criadoEm;
    protected String atualizadoEm;

    public CarrinhoSessaoModel() {}

    public CarrinhoSessaoModel(int id, String status, int total, String criadoEm, String atualizadoEm) {
        this.id = id;
        this.status = status;
        this.total = total;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public String getCriadoEm() { return criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }

    public String getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(String atualizadoEm) { this.atualizadoEm = atualizadoEm; }

    @Override
    public String toString() {
        return "CarrinhoSessaoModel{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", total=" + total +
                ", criadoEm='" + criadoEm + '\'' +
                ", atualizadoEm='" + atualizadoEm + '\'' +
                '}';
    }
}