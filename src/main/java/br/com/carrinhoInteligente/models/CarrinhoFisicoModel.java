package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "carrinho_fisico")
public class CarrinhoFisicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo_qr", nullable = false)
    private String codigoQr;

    @Column(nullable = false)
    private String status;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @ManyToOne
    @JoinColumn(name = "id_loja", referencedColumnName = "idLoja")
    private LojaModel loja;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrinho_sessao_id", referencedColumnName = "id", updatable = false, insertable = false)
    private CarrinhoSessaoModel carrinhoSessao;

    @Column(name = "carrinho_sessao_id")
    private int idCarrinhoSessao;

    public CarrinhoFisicoModel() {}

    protected CarrinhoFisicoModel(String codigoQr, String status, LojaModel loja) {
        this.codigoQr = codigoQr;
        this.status = status;
        this.loja = loja;
        this.criadoEm = LocalDateTime.now();
    }

    public static CarrinhoFisicoModel criar(String codigoQr, String status, LojaModel loja) {
        return new CarrinhoFisicoModel(codigoQr, status, loja);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCodigoQr() { return codigoQr; }
    public void setCodigoQr(String codigoQr) { this.codigoQr = codigoQr; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LojaModel getLoja() { return loja; }
    public void setLoja(LojaModel loja) { this.loja = loja; }

    public int getIdCarrinhoSessao() { return idCarrinhoSessao; }
    public void setIdCarrinhoSessao(int idCarrinhoSessao) { this.idCarrinhoSessao = idCarrinhoSessao; }

    public CarrinhoSessaoModel getCarrinhoSessao() { return carrinhoSessao; }
    public void setCarrinhoSessao(CarrinhoSessaoModel carrinhoSessao) { this.carrinhoSessao = carrinhoSessao; }
}
