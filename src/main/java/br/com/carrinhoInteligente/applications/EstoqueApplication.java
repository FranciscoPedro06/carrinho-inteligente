package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Estoque;
import br.com.carrinhoInteligente.models.EstoqueModel;
import br.com.carrinhoInteligente.models.ProdutoModel;
import br.com.carrinhoInteligente.repositories.EstoqueRepository;
import br.com.carrinhoInteligente.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueApplication {

    private final EstoqueRepository repository;
    private final ProdutoRepository produtoRepository;
    private static final Logger logger = LoggerFactory.getLogger(EstoqueApplication.class);

    public EstoqueApplication(EstoqueRepository repository, ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.produtoRepository = produtoRepository;
    }

    public Estoque salvar(Estoque estoque) {
        logger.info("Salvando estoque: {}", estoque);

        if (estoque == null) {
            throw new IllegalArgumentException("Estoque não pode ser nulo");
        }

        if (estoque.getQuantidade() < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }

        EstoqueModel model = estoque.toModel();

        if (model.getCriadoEm() == null) {
            model.setCriadoEm(LocalDateTime.now());
        }

        if (estoque.getIdProduto() != 0) {
            try {
                ProdutoModel produto = produtoRepository.getReferenceById(estoque.getIdProduto());
                model.setProduto(produto);
                logger.info("Produto vinculado com sucesso: ID {}", estoque.getIdProduto());
            } catch (EntityNotFoundException e) {
                logger.error("Produto não encontrado: {}", estoque.getIdProduto(), e);
                throw new IllegalArgumentException("Produto com ID " + estoque.getIdProduto() + " não encontrado");
            }
        } else {
            logger.info("Nenhum produto fornecido. Produto será null.");
        }

        EstoqueModel salvo = repository.save(model);
        logger.info("Estoque salvo com ID: {}", salvo.getIdEstoque());
        return Estoque.fromModel(salvo);
    }

    public List<Estoque> listarTodos() {
        logger.info("Listando todos os estoques");
        return repository.findAll()
                .stream()
                .map(Estoque::fromModel)
                .toList();
    }

    public Optional<Estoque> buscarPorId(int id) {
        logger.info("Buscando estoque por ID: {}", id);
        return repository.findById(id)
                .map(Estoque::fromModel);
    }

    public boolean atualizar(int id, Estoque estoqueAtualizado) {
        logger.info("Atualizando estoque ID: {}", id);

        if (!repository.existsById(id)) {
            logger.warn("Estoque com ID {} não encontrado", id);
            return false;
        }

        EstoqueModel existente = repository.findById(id).orElseThrow();

        if (estoqueAtualizado.getQuantidade() != 0) {
            existente.setQuantidade(estoqueAtualizado.getQuantidade());
        }

        if (estoqueAtualizado.getLocalizacao() != null && !estoqueAtualizado.getLocalizacao().isEmpty()) {
            existente.setLocalizacao(estoqueAtualizado.getLocalizacao());
        }

        if (estoqueAtualizado.getCriadoEm() != null) {
            existente.setCriadoEm(estoqueAtualizado.getCriadoEm());
        }

        if (estoqueAtualizado.getExpiraEm() != null) {
            existente.setExpiraEm(estoqueAtualizado.getExpiraEm());
        }

        if (estoqueAtualizado.getIdProduto() != 0) {
            try {
                ProdutoModel produto = produtoRepository.getReferenceById(estoqueAtualizado.getIdProduto());
                existente.setProduto(produto);
                logger.info("Produto atualizado para ID: {}", estoqueAtualizado.getIdProduto());
            } catch (EntityNotFoundException e) {
                throw new IllegalArgumentException("Produto com ID " + estoqueAtualizado.getIdProduto() + " não encontrado");
            }
        }

        repository.save(existente);
        logger.info("Estoque atualizado com sucesso: ID {}", id);
        return true;
    }

    public boolean deletar(int id) {
        logger.info("Deletando estoque ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Estoque com ID {} não encontrado para deleção", id);
            return false;
        }

        repository.deleteById(id);
        logger.info("Estoque deletado com sucesso: ID {}", id);
        return true;
    }
}