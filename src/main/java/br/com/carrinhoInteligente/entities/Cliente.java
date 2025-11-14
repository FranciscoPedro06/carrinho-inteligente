package br.com.carrinhoInteligente.entities;

import br.com.carrinhoInteligente.models.ClienteModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Cliente {

    private int idCliente;
    private String nome;
    private String email;
    private String telefone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime criadoEm;

    public Cliente() {}

    public Cliente(int idCliente, String nome, String email, String telefone, LocalDateTime criadoEm) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.criadoEm = criadoEm;
    }

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

    public ClienteModel toModel(){
        return new ClienteModel(
                this.getNome(),
                this.getEmail(),
                this.getTelefone()
        );
    }

    public static Cliente fromModel(ClienteModel model) {
        return new Cliente(
                model.getIdCliente(),
                model.getNome(),
                model.getEmail(),
                model.getTelefone(),
                LocalDateTime.now()
        );
    }
}
