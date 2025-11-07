package br.com.carrinhoInteligente.entities;

import java.time.LocalDateTime;

public class CarrinhoFisico {
    private int id;
    private String codigoQr;
    private String status;
    private LocalDateTime criadoEm;
    private int idLoja;
    private Integer idCarrinhoSessao;

    public CarrinhoFisico(int id, String codigoQr, String status, LocalDateTime criadoEm, int idLoja, Integer idCarrinhoSessao) {
        this.id = id;
        this.codigoQr = codigoQr;
        this.status = status;
        this.criadoEm = criadoEm;
        this.idLoja = idLoja;
        this.idCarrinhoSessao = idCarrinhoSessao;
    }

    public CarrinhoFisico(String codigoQr, String status, int idLoja) {
        this(0, codigoQr, status, LocalDateTime.now(), idLoja, null);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCodigoQr() { return codigoQr; }
    public void setCodigoQr(String codigoQr) { this.codigoQr = codigoQr; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public int getIdLoja() { return idLoja; }
    public void setIdLoja(int idLoja) { this.idLoja = idLoja; }

    public Integer getIdCarrinhoSessao() { return idCarrinhoSessao; }
    public void setIdCarrinhoSessao(Integer idCarrinhoSessao) { this.idCarrinhoSessao = idCarrinhoSessao; }
}
