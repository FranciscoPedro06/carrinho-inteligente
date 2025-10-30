package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrinho_sessao")
public class CarrinhoSessaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;
    private int total;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @Column(name = "id_cliente")
    private int id_cliente;

    // Relação com Cliente (várias sessões pertencem a um cliente)
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    private ClienteModel cliente;

    @Column(name = "pagamento_id")
    private int pagamento_id;

    //  Relação 1:1 com Pagamento
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PagamentoModel pagamento;

    //  Relação 1:N com Itens do Carrinho
    @OneToMany(mappedBy = "carrinhoSessao", cascade = CascadeType.ALL)
    private List<CarrinhoItemModel> itens = new ArrayList<>();

    public CarrinhoSessaoModel() {}

    public CarrinhoSessaoModel(String status, int total, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.status = status;
        this.total = total;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public PagamentoModel getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoModel pagamento) {
        this.pagamento = pagamento; }

    public List<CarrinhoItemModel> getItens() {
        return itens;
    }

    public void setItens(List<CarrinhoItemModel> itens) {
        this.itens = itens;
    }
}
