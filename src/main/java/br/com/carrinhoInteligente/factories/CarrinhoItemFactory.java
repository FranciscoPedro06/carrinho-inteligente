package br.com.carrinhoInteligente.factories;

import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.models.CarrinhoItemModel;

public class CarrinhoItemFactory {

    public static CarrinhoItem toEntity(CarrinhoItemModel model) {
        return new CarrinhoItem(
                model.getId(),
                model.getQuantidade(),
                model.getPrecoUnit(),
                model.getPrecoTotal(),
                model.getAdicionadoEm(),
                model.getCarrinhoSessao() != null ? model.getCarrinhoSessao().getId() : 0,
                model.getProduto() != null ? model.getProduto().getIdProduto() : 0
        );
    }

    public static CarrinhoItemModel toModel(CarrinhoItem entity) {
        CarrinhoItemModel model = new CarrinhoItemModel();
        model.setId(entity.getId());
        model.setQuantidade(entity.getQuantidade());
        model.setPrecoUnit(entity.getPrecoUnit());
        model.setPrecoTotal(entity.getPrecoTotal());
        model.setAdicionadoEm(entity.getAdicionadoEm());
        model.setIdCarrinhoSessao(entity.getIdCarrinhoSessao());
        model.setIdProduto(entity.getIdProduto());
        return model;
    }
}
