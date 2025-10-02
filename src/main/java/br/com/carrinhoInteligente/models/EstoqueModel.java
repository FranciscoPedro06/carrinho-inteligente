package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "estoque")
public class EstoqueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantidade;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "expira_em")
    private LocalDateTime expiraEm;

    public EstoqueModel() {
    }

    public EstoqueModel(int id, int quantidade, LocalDateTime criadoEm, LocalDateTime expiraEm) {
        this.id = id;
        this.quantidade = quantidade;
        this.criadoEm = criadoEm;
        this.expiraEm = expiraEm;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getExpiraEm() { return expiraEm; }
    public void setExpiraEm(LocalDateTime expiraEm) { this.expiraEm = expiraEm; }
}
