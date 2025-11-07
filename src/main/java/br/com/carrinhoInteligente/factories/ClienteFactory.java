package br.com.carrinhoInteligente.factories;

import br.com.carrinhoInteligente.entities.Cliente;
import br.com.carrinhoInteligente.models.ClienteModel;

public class ClienteFactory {

    public static Cliente toEntity(ClienteModel model) {
        return new Cliente(
                model.getIdCliente(),
                model.getNome(),
                model.getCriadoEm()
        );
    }

    public static ClienteModel toModel(Cliente entity) {
        ClienteModel model = new ClienteModel();
        model.setIdCliente(entity.getIdCliente());
        model.setNome(entity.getNome());
        model.setCriadoEm(entity.getCriadoEm());
        return model;
    }
}
