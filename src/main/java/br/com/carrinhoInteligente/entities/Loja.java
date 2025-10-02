package br.com.carrinhoInteligente.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class Loja {
    private int idLoja;
    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime criadoEm;

    public Loja(int idLoja, String nome, LocalDateTime criadoEm) {
        this.idLoja = idLoja;
        this.nome = nome;
        this.criadoEm = criadoEm;
    }
    public Loja() {}

    public int getIdLoja() { return idLoja; }
    public void setIdLoja(int idLoja) { this.idLoja = idLoja; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }
}
