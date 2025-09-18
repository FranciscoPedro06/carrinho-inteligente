package br.com.carrinhoInteligente.entities;

import java.time.LocalDateTime;

public class CarrinhoFisicoEntity {
    private int id;
    protected long lojaId;
    protected String codigoQr;
    protected String status;
    protected LocalDateTime criadoEm;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public long getLojaId() { return lojaId; }
    public void setLojaId(long lojaId) { this.lojaId = lojaId; }

    public String getCodigoQr() { return codigoQr; }
    public void setCodigoQr(String codigoQr) { this.codigoQr = codigoQr; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}