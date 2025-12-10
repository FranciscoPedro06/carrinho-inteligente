package br.com.carrinhoInteligente.entities;

import br.com.carrinhoInteligente.models.LojaModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public static Loja fromModel(LojaModel model) {
        return new Loja(
                model.getIdLoja(),
                model.getNome(),
                model.getCriadoEm()
        );
    }

    public LojaModel toModel() {
        LojaModel model = new LojaModel();
        model.setIdLoja(this.idLoja);
        model.setNome(this.nome);
        model.setCriadoEm(this.criadoEm);
        return model;
    }

    public int getIdLoja() { return idLoja; }
    public void setIdLoja(int idLoja) { this.idLoja = idLoja; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    @Override
    public String toString() {
        return "Loja{" +
                "idLoja=" + idLoja +
                ", nome='" + nome + '\'' +
                ", criadoEm=" + criadoEm +
                '}';
    }
}