package br.com.carrinhoInteligente.models;


import java.time.LocalDateTime;

public class CarrinhoFisicoModel {
    private int id;
    private String codigoQr;
    private String status;
    private String criadoEm;

    public CarrinhoFisicoModel(int id, String codigoQr, String status, String criadoEm) {
        this.id = id;
        this.codigoQr = codigoQr;
        this.status = status;
        this.criadoEm = criadoEm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoQr() {
        return codigoQr;
    }

    public void setCodigoQr(String codigoQr) {
        this.codigoQr = codigoQr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }
}