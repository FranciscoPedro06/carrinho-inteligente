package br.com.carrinhoInteligente.factories;

import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import java.util.stream.Collectors;

public class CarrinhoSessaoFactory {

    public static CarrinhoSessao toEntity(CarrinhoSessaoModel model) {
        CarrinhoSessao entity = new CarrinhoSessao(
                model.getId(),
                model.getStatus(),
                model.getTotal(),
                model.getCriadoEm(),
                model.getAtualizadoEm(),
                model.getIdCliente(),
                model.getIdPagamento()
        );

        if (model.getItens() != null) {
            entity.setItensIds(model.getItens()
                    .stream()
                    .map(item -> item.getId())
                    .collect(Collectors.toList()));
        }

        return entity;
    }

    public static CarrinhoSessaoModel toModel(CarrinhoSessao entity) {
        CarrinhoSessaoModel model = new CarrinhoSessaoModel();
        model.setId(entity.getId());
        model.setStatus(entity.getStatus());
        model.setTotal(entity.getTotal());
        model.setCriadoEm(entity.getCriadoEm());
        model.setAtualizadoEm(entity.getAtualizadoEm());
        model.setIdCliente(entity.getIdCliente());
        model.setIdPagamento(entity.getIdPagamento());
        return model;
    }
}
