package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamento")
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String metodo;
    private Double valor;
    private String status;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    //  Relação 1:1 com CarrinhoSessao
    @OneToOne(mappedBy = "pagamento")
    private CarrinhoSessaoModel carrinhoSessao;

    public PagamentoModel() {}

    public PagamentoModel(String metodo, Double valor, String status, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
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

    public CarrinhoSessaoModel getCarrinhoSessao() { return carrinhoSessao; }
    public void setCarrinhoSessao(CarrinhoSessaoModel carrinhoSessao) { this.carrinhoSessao = carrinhoSessao; }
}
