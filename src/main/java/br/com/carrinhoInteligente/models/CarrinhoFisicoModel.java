package br.com.carrinhoInteligente.models;

public class CarrinhoFisicoModel {
    private int id;
    protected String codigoQr;
    protected String status;
    protected String criadoEm;

    public CarrinhoFisicoModel() {}

    public CarrinhoFisicoModel(int id, String codigoQr, String status, String criadoEm) {
        this.id = id;
        this.codigoQr = codigoQr;
        this.status = status;
        this.criadoEm = criadoEm;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCodigoQr() { return codigoQr; }
    public void setCodigoQr(String codigoQr) { this.codigoQr = codigoQr; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCriadoEm() { return criadoEm; }
    public void setCriadoEm(String criadoEm) { this.criadoEm = criadoEm; }

    @Override
    public String toString() {
        return "CarrinhoFisicoModel{" +
                "id=" + id +
                ", codigoQr='" + codigoQr + '\'' +
                ", status='" + status + '\'' +
                ", criadoEm='" + criadoEm + '\'' +
                '}';
    }
}