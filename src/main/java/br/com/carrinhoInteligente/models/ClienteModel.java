package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    private String nome;
    private String email;
    private String telefone;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    //  Relação 1:N com CarrinhoSessao
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<CarrinhoSessaoModel> sessoes = new ArrayList<>();

    public ClienteModel() {}

    public ClienteModel(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.criadoEm = LocalDateTime.now();
    }

    // Getters e Setters
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public List<CarrinhoSessaoModel> getSessoes() { return sessoes; }
    public void setSessoes(List<CarrinhoSessaoModel> sessoes) { this.sessoes = sessoes; }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", criadoEm=" + criadoEm +
                '}';
    }
}