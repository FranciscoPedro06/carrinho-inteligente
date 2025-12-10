package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.models.CarrinhoItemModel;
import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import br.com.carrinhoInteligente.models.ProdutoModel;
import br.com.carrinhoInteligente.repositories.CarrinhoItemRepository;
import br.com.carrinhoInteligente.repositories.CarrinhoSessaoRepository;
import br.com.carrinhoInteligente.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoItemApplication {

    private final CarrinhoItemRepository repository;
    private final CarrinhoSessaoRepository sessaoRepository;
    private final ProdutoRepository produtoRepository;

    public CarrinhoItemApplication(CarrinhoItemRepository repository, CarrinhoSessaoRepository sessaoRepository, ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.sessaoRepository = sessaoRepository;
        this.produtoRepository = produtoRepository;
    }

    public CarrinhoItem salvar(CarrinhoItem item) {
        CarrinhoItemModel model = item.toModel();

        if (item.getIdCarrinhoSessao() != 0) {
            try {
                CarrinhoSessaoModel sessao = sessaoRepository.getReferenceById(item.getIdCarrinhoSessao());
                model.setCarrinhoSessao(sessao);
            } catch (EntityNotFoundException e) {
                throw new IllegalArgumentException("Sessão com ID " + item.getIdCarrinhoSessao() + " não encontrada");
            }
        }

        if (item.getIdProduto() != 0) {
            try {
                ProdutoModel produto = produtoRepository.getReferenceById(item.getIdProduto());
                model.setProduto(produto);
            } catch (EntityNotFoundException e) {
                throw new IllegalArgumentException("Produto com ID " + item.getIdProduto() + " não encontrada");
            }
        }

        if (model.getPrecoTotal() == null && model.getPrecoUnit() != null) {
            model.setPrecoTotal(model.getPrecoUnit() * model.getQuantidade());
        }

        CarrinhoItemModel salvo = repository.save(model);
        return CarrinhoItem.fromModel(salvo);
    }

    public List<CarrinhoItem> listarTodos() {
        return repository.findAll()
                .stream()
                .map(CarrinhoItem::fromModel)
                .toList();
    }

    public Optional<CarrinhoItem> buscarPorId(int id) {
        return repository.findById(id)
                .map(CarrinhoItem::fromModel);
    }

    public boolean atualizar(int id, CarrinhoItem novoItem) {
        if (!repository.existsById(id)) {
            return false;
        }

        CarrinhoItemModel existente = repository.findById(id).orElseThrow();

        if (novoItem.getQuantidade() != 0) {
            existente.setQuantidade(novoItem.getQuantidade());
        }

        if (novoItem.getPrecoUnit() != null) {
            existente.setPrecoUnit(novoItem.getPrecoUnit());
        }

        if (novoItem.getPrecoTotal() != null) {
            existente.setPrecoTotal(novoItem.getPrecoTotal());
        }

        if (novoItem.getAdicionadoEm() != null) {
            existente.setAdicionadoEm(novoItem.getAdicionadoEm());
        }

        if (existente.getPrecoUnit() != null &&
                (novoItem.getQuantidade() != 0 || novoItem.getPrecoUnit() != null)) {
            existente.setPrecoTotal(existente.getPrecoUnit() * existente.getQuantidade());
        }

        if (novoItem.getIdCarrinhoSessao() != 0) {
            try {
                CarrinhoSessaoModel sessao = sessaoRepository.getReferenceById(novoItem.getIdCarrinhoSessao());
                existente.setCarrinhoSessao(sessao);
            } catch (EntityNotFoundException e) {
                throw new IllegalArgumentException("Sessão com ID " + novoItem.getIdCarrinhoSessao() + " não encontrada");
            }
        }

        if (novoItem.getIdProduto() != 0) {
            try {
                ProdutoModel produto = produtoRepository.getReferenceById(novoItem.getIdProduto());
                existente.setProduto(produto);
            } catch (EntityNotFoundException e) {
                throw new IllegalArgumentException("Produto com ID " + novoItem.getIdProduto() + " não encontrada");
            }
        }

        repository.save(existente);
        return true;
    }

    public boolean deletar(int id) {
        if (!repository.existsById(id)) return false;

        repository.deleteById(id);
        return true;
    }
}