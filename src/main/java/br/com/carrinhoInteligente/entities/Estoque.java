package br.com.carrinhoInteligente.entities;

import br.com.carrinhoInteligente.models.EstoqueModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Estoque {

    private int idEstoque;
    private int quantidade;
    private String localizacao;
    private int idProduto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime criadoEm;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime expiraEm;

    public Estoque() {}

    public Estoque(int idEstoque, int quantidade, String localizacao, int idProduto,
                   LocalDateTime criadoEm, LocalDateTime expiraEm) {
        this.idEstoque = idEstoque;
        this.quantidade = quantidade;
        this.localizacao = localizacao;
        this.idProduto = idProduto;
        this.criadoEm = criadoEm;
        this.expiraEm = expiraEm;
    }

    // Getters e Setters
    public int getIdEstoque() { return idEstoque; }
    public void setIdEstoque(int idEstoque) { this.idEstoque = idEstoque; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getExpiraEm() { return expiraEm; }
    public void setExpiraEm(LocalDateTime expiraEm) { this.expiraEm = expiraEm; }

    public EstoqueModel toModel() {
        EstoqueModel model = new EstoqueModel();
        model.setIdEstoque(this.idEstoque);
        model.setQuantidade(this.quantidade);
        model.setLocalizacao(this.localizacao);
        model.setIdProduto(this.idProduto);
        model.setCriadoEm(this.criadoEm); // Adicione este setter no Model
        model.setExpiraEm(this.expiraEm); // Adicione este setter no Model
        return model;
    }

    public static Estoque fromModel(EstoqueModel model) {
        return new Estoque(
                model.getIdEstoque(),
                model.getQuantidade(),
                model.getLocalizacao(),
                model.getProduto() != null ? model.getProduto().getIdProduto() : 0,
                model.getCriadoEm(), // Adicione este getter no Model
                model.getExpiraEm()  // Adicione este getter no Model
        );
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "idEstoque=" + idEstoque +
                ", quantidade=" + quantidade +
                ", localizacao='" + localizacao + '\'' +
                ", idProduto=" + idProduto +
                ", criadoEm=" + criadoEm +
                ", expiraEm=" + expiraEm +
                '}';
    }
}