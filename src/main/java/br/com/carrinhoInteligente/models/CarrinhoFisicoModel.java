package br.com.carrinhoInteligente.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "carrinho_fisico")
public class CarrinhoFisicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigoQr;
    private String status;
    private LocalDateTime criadoEm;

    // Construtor padrão
    public CarrinhoFisicoModel() {
    }

    // Construtor com parâmetros
    public CarrinhoFisicoModel(int id, String codigoQr, String status, LocalDateTime criadoEm) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Código QR: " + codigoQr + "\n" +
                "Status: " + status + "\n" +
                "Criado em: " + criadoEm;
    }
}
