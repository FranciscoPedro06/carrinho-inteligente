package br.com.carrinhoInteligente.entities;

import java.time.LocalDateTime;
import java.util.List;

public class CarrinhoSessao {

    private int id;
    private String status;
    private int total;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private int idCliente;
    private int idPagamento;
    private List<Integer> itensIds; // Apenas IDs dos itens

    public CarrinhoSessao() {}

    public CarrinhoSessao(int id, String status, int total, LocalDateTime criadoEm, LocalDateTime atualizadoEm, int idCliente, int idPagamento) {
        this.id = id;
        this.status = status;
        this.total = total;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
        this.idCliente = idCliente;
        this.idPagamento = idPagamento;
    }

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

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdPagamento() { return idPagamento; }
    public void setIdPagamento(int idPagamento) { this.idPagamento = idPagamento; }

    public List<Integer> getItensIds() { return itensIds; }
    public void setItensIds(List<Integer> itensIds) { this.itensIds = itensIds; }
}
