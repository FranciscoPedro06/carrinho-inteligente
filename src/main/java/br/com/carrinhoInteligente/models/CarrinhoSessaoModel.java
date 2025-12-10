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

    // ========= CLIENTE =========
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClienteModel cliente; // Remove idCliente separado

    // ========= PAGAMENTO =========
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id", nullable = false)
    private PagamentoModel pagamento; // Remove idPagamento separado

    // ========= ITENS DO CARRINHO =========
    @OneToMany(mappedBy = "carrinhoSessao", cascade = CascadeType.ALL)
    private List<CarrinhoItemModel> itens = new ArrayList<>();

    // ========= CONSTRUTORES =========
    public CarrinhoSessaoModel() {}

    public CarrinhoSessaoModel(String status, int total, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
        this.status = status;
        this.total = total;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    // ========= GETTERS E SETTERS =========
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }

    public ClienteModel getCliente() { return cliente; }
    public void setCliente(ClienteModel cliente) { this.cliente = cliente; }

    public PagamentoModel getPagamento() { return pagamento; }
    public void setPagamento(PagamentoModel pagamento) { this.pagamento = pagamento; }

    public List<CarrinhoItemModel> getItens() { return itens; }
    public void setItens(List<CarrinhoItemModel> itens) { this.itens = itens; }

    public void setIdPagamento(Integer idPagamento) {
    }

    public void setIdCliente(Integer idCliente) {
    }
}
