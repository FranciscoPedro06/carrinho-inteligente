package br.com.carrinhoInteligente.factories;

import br.com.carrinhoInteligente.models.LojaModel;
import org.springframework.stereotype.Component;

@Component
public class LojaFactory {

    public LojaModel criarLoja(String nome) {
        return LojaModel.criar(nome);
    }
}
