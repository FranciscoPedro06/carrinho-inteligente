package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "carrinho_fisico")
public class CarrinhoFisicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo_qr")
    private String codigoQr;

    private String status;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    //  Relação com Loja (muitos carrinhos pertencem a uma loja)
    @ManyToOne
    @JoinColumn(name = "id_loja", referencedColumnName = "idLoja")
    private LojaModel loja;

    @Column(name = "carrinho_sessao_id")
    private int idCarrinhoSessao;

    //  Relação 1:1 com CarrinhoSessao
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrinho_sessao_id", referencedColumnName = "id", updatable = false, insertable = false)
    private CarrinhoSessaoModel carrinhoSessao;

    public CarrinhoFisicoModel() {}

    public CarrinhoFisicoModel(String codigoQr, String status, LocalDateTime criadoEm) {
        this.codigoQr = codigoQr;
        this.status = status;
        this.criadoEm = criadoEm;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoQr() {
        return codigoQr;
    }

    public void setCodigoQr(String codigoQr) {
        this.codigoQr = codigoQr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LojaModel getLoja() {
        return loja;
    }

    public void setLoja(LojaModel loja) {
        this.loja = loja;
    }

    public CarrinhoSessaoModel getCarrinhoSessao() {
        return carrinhoSessao;
    }

    public void setCarrinhoSessao(CarrinhoSessaoModel carrinhoSessao) {
        this.carrinhoSessao = carrinhoSessao;
    }
}
