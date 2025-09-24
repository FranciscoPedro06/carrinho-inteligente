package br.com.carrinhoInteligente.models;

public class PagamentoModel {
    private int id;
    protected String metodo;
    protected Double valor;
    protected String status;
    protected String criadoEm;
    protected String atualizadoEm;

    public PagamentoModel() {}

    public PagamentoModel(int id, String metodo, Double valor, String status, String criadoEm, String atualizadoEm) {
        this.id = id;
        this.metodo = metodo;
        this.valor = valor;
        this.status = status;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCriadoEm() { return criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }

    public String getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(String atualizadoEm) { this.atualizadoEm = atualizadoEm; }

    @Override
    public String toString() {
        return "PagamentoModel{" +
                "id=" + id +
                ", metodo='" + metodo + '\'' +
                ", valor=" + valor +
                ", status='" + status + '\'' +
                ", criadoEm='" + criadoEm + '\'' +
                ", atualizadoEm='" + atualizadoEm + '\'' +
                '}';
    }
}