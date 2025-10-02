package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    private String nome;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    public ClienteModel() {
    }

    public ClienteModel(String nome, LocalDateTime criadoEm) {
        this.nome = nome;
        this.criadoEm = criadoEm;
    }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}
