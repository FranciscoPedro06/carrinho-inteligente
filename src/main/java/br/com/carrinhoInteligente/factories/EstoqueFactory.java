package br.com.carrinhoInteligente.factories;

import br.com.carrinhoInteligente.models.EstoqueModel;
import org.springframework.stereotype.Component;

@Component
public class EstoqueFactory {

    public EstoqueModel criarEstoque(int quantidade) {
        return EstoqueModel.criar(quantidade);
    }
}
