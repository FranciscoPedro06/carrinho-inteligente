package br.com.carrinhoInteligente.entities;

import java.time.LocalDateTime;

public class Cliente {
    private int idCliente;
    private String nome;
    private LocalDateTime criadoEm;

    public Cliente(int idCliente, String nome, LocalDateTime criadoEm) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.criadoEm = criadoEm;
    }

    public Cliente() {

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }
}
