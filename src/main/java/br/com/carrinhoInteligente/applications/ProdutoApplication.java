package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Produto;
import br.com.carrinhoInteligente.models.LojaModel;
import br.com.carrinhoInteligente.models.ProdutoModel;
import br.com.carrinhoInteligente.repositories.LojaRepository;
import br.com.carrinhoInteligente.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoApplication {

    private final ProdutoRepository repository;
    private final LojaRepository lojaRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProdutoApplication.class);

    public ProdutoApplication(ProdutoRepository repository, LojaRepository lojaRepository) {
        this.repository = repository;
        this.lojaRepository = lojaRepository;
    }

    public Produto salvar(Produto produto) {
        logger.info("Salvando produto: {}", produto);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }

        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório");
        }

        if (produto.getPreco() == null || produto.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço do produto deve ser maior que zero");
        }

        ProdutoModel model = produto.toModel();

        if (model.getCriadoEm() == null) {
            model.setCriadoEm(LocalDateTime.now());
        }

        if (produto.getIdLoja() != 0) {
            try {
                LojaModel loja = lojaRepository.getReferenceById(produto.getIdLoja());
                model.setLoja(loja);
                logger.info("Loja vinculada com sucesso: ID {}", produto.getIdLoja());
            } catch (EntityNotFoundException e) {
                logger.error("Loja não encontrada: {}", produto.getIdLoja(), e);
                throw new IllegalArgumentException("Loja com ID " + produto.getIdLoja() + " não encontrada");
            }
        } else {
            logger.info("Nenhuma loja fornecida. Produto será sem loja.");
        }

        ProdutoModel salvo = repository.save(model);
        logger.info("Produto salvo com ID: {}", salvo.getIdProduto());
        return Produto.fromModel(salvo);
    }

    public List<Produto> listarTodos() {
        logger.info("Listando todos os produtos");
        return repository.findAll()
                .stream()
                .map(Produto::fromModel)
                .toList();
    }

    public Optional<Produto> buscarPorId(int id) {
        logger.info("Buscando produto por ID: {}", id);
        return repository.findById(id)
                .map(Produto::fromModel);
    }

    public boolean atualizar(int id, Produto produtoAtualizado) {
        logger.info("Atualizando produto ID: {}", id);

        if (!repository.existsById(id)) {
            logger.warn("Produto com ID {} não encontrado", id);
            return false;
        }

        ProdutoModel existente = repository.findById(id).orElseThrow();

        if (produtoAtualizado.getCodigoBarras() != null && !produtoAtualizado.getCodigoBarras().isEmpty()) {
            existente.setCodigoBarras(produtoAtualizado.getCodigoBarras());
        }

        if (produtoAtualizado.getNome() != null && !produtoAtualizado.getNome().isEmpty()) {
            existente.setNome(produtoAtualizado.getNome());
        }

        if (produtoAtualizado.getPreco() != null && produtoAtualizado.getPreco() > 0) {
            existente.setPreco(produtoAtualizado.getPreco());
        }

        if (produtoAtualizado.getCriadoEm() != null) {
            existente.setCriadoEm(produtoAtualizado.getCriadoEm());
        }

        if (produtoAtualizado.getIdLoja() != 0) {
            try {
                LojaModel loja = lojaRepository.getReferenceById(produtoAtualizado.getIdLoja());
                existente.setLoja(loja);
                logger.info("Loja atualizada para ID: {}", produtoAtualizado.getIdLoja());
            } catch (EntityNotFoundException e) {
                throw new IllegalArgumentException("Loja com ID " + produtoAtualizado.getIdLoja() + " não encontrada");
            }
        }

        repository.save(existente);
        logger.info("Produto atualizado com sucesso: ID {}", id);
        return true;
    }

    public boolean deletar(int id) {
        logger.info("Deletando produto ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Produto com ID {} não encontrado para deleção", id);
            return false;
        }

        repository.deleteById(id);
        logger.info("Produto deletado com sucesso: ID {}", id);
        return true;
    }
}