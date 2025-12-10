package br.com.carrinhoInteligente.entities;

import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class CarrinhoSessao {
    private int id;
    private String status;
    private int total;
    private Integer idCliente;
    private Integer idPagamento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime criadoEm;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime atualizadoEm;

    public CarrinhoSessao(int id, String status, int total, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.id = id;
        this.status = status;
        this.total = total;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }
    public CarrinhoSessao() {}


    public CarrinhoSessaoModel toModel() {
        CarrinhoSessaoModel model = new CarrinhoSessaoModel();
        model.setId(this.id);
        model.setStatus(this.status);
        model.setTotal(this.total);
        model.setCriadoEm(this.criadoEm);
        model.setAtualizadoEm(this.atualizadoEm);
        model.setIdCliente(this.idCliente);
        model.setIdPagamento(this.idPagamento);
        return model;
    }


    public static CarrinhoSessao fromModel(CarrinhoSessaoModel model) {
        return new CarrinhoSessao(
                model.getId(),
                model.getStatus(),
                model.getTotal(),
                model.getCriadoEm(),
                model.getAtualizadoEm()
        );
    }

    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public Integer getIdPagamento() { return idPagamento; }
    public void setIdPagamento(Integer idPagamento) { this.idPagamento = idPagamento; }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}