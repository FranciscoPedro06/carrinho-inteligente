package br.com.carrinhoInteligente.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class CarrinhoFisico {
    private int id;
    private String codigoQr;
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime criadoEm;

    public CarrinhoFisico(int id, String codigoQr, String status, LocalDateTime criadoEm) {
        this.id = id;
        this.codigoQr = codigoQr;
        this.status = status;
        this.criadoEm = criadoEm;
    }

    public CarrinhoFisico() { }

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

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
