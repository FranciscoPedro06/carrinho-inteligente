package br.com.carrinhoInteligente.entities;

import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class CarrinhoFisico {
    private int id;
    private String codigoQr;
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime criadoEm;

    private int idLoja;
    private int idCarrinhoSessao;

    public CarrinhoFisico(int id, String codigoQr, String status, LocalDateTime criadoEm, int idLoja, int idCarrinhoSessao) {
        this.id = id;
        this.codigoQr = codigoQr;
        this.status = status;
        this.criadoEm = criadoEm;
        this.idLoja = idLoja;
        this.idCarrinhoSessao = idCarrinhoSessao;
    }

    public static CarrinhoFisico fromModel(CarrinhoFisicoModel model) {
        return new CarrinhoFisico(
                model.getId(),
                model.getCodigoQr(),
                model.getStatus(),
                model.getCriadoEm(),
                model.getIdLoja(),
                model.getIdCarrinhoSessao()
        );
    }

    public CarrinhoFisicoModel toModel() {
        CarrinhoFisicoModel model = new CarrinhoFisicoModel();
        model.setId(this.id);
        model.setCodigoQr(this.codigoQr);
        model.setStatus(this.status);
        model.setCriadoEm(this.criadoEm);
        return model;
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

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public int getIdCarrinhoSessao() {
        return idCarrinhoSessao;
    }

    public void setIdCarrinhoSessao(int idCarrinhoSessao) {
        this.idCarrinhoSessao = idCarrinhoSessao;
    }
}