package br.com.carrinhoInteligente.factories;

import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
import br.com.carrinhoInteligente.models.LojaModel;
import org.springframework.stereotype.Component;

@Component
public class CarrinhoFisicoFactory {

    public CarrinhoFisicoModel criarCarrinho(String codigoQr, String status, LojaModel loja) {
        return CarrinhoFisicoModel.criar(codigoQr, status, loja);
    }
}
