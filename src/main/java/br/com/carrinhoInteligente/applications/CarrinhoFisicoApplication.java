package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
import br.com.carrinhoInteligente.models.LojaModel;
import br.com.carrinhoInteligente.repositories.CarrinhoFisicoRepository;
import br.com.carrinhoInteligente.factories.CarrinhoFisicoFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoFisicoApplication {

    private final CarrinhoFisicoRepository repository;
    private final CarrinhoFisicoFactory factory;

    public CarrinhoFisicoApplication(CarrinhoFisicoRepository repository, CarrinhoFisicoFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public CarrinhoFisicoModel salvar(String codigoQr, String status, LojaModel loja) {
        CarrinhoFisicoModel carrinho = factory.criarCarrinho(codigoQr, status, loja);
        return repository.save(carrinho);
    }

    public List<CarrinhoFisicoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<CarrinhoFisicoModel> buscarPorId(int id) {
        return repository.findById(id);
    }

    public boolean atualizar(int id, CarrinhoFisicoModel novoCarrinho) {
        if (repository.existsById(id)) {
            novoCarrinho.setId(id);
            repository.save(novoCarrinho);
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
