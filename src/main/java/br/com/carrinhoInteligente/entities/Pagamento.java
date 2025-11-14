package br.com.carrinhoInteligente.entities;

import br.com.carrinhoInteligente.models.PagamentoModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class Pagamento {

    private int id;
    private String metodo;
    private Double valor;
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime criadoEm;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime atualizadoEm;

    public Pagamento() {}

    public Pagamento(int id, String metodo, Double valor, String status,
                     LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
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

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }

    public PagamentoModel toModel() {
        PagamentoModel model = new PagamentoModel();
        model.setId(this.id);
        model.setMetodo(this.metodo);
        model.setValor(this.valor);
        model.setStatus(this.status);
        model.setCriadoEm(this.criadoEm);
        model.setAtualizadoEm(this.atualizadoEm);
        return model;
    }

    public static Pagamento fromModel(PagamentoModel model) {
        return new Pagamento(
                model.getId(),
                model.getMetodo(),
                model.getValor(),
                model.getStatus(),
                model.getCriadoEm(),
                model.getAtualizadoEm()
        );
    }
}
