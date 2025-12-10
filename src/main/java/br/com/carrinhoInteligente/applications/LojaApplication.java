package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Loja;
import br.com.carrinhoInteligente.models.LojaModel;
import br.com.carrinhoInteligente.repositories.LojaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LojaApplication {

    private final LojaRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(LojaApplication.class);

    public LojaApplication(LojaRepository repository) {
        this.repository = repository;
    }

    public Loja salvar(Loja loja) {
        logger.info("Salvando loja: {}", loja);

        if (loja == null) {
            throw new IllegalArgumentException("Loja não pode ser nula");
        }

        if (loja.getNome() == null || loja.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da loja é obrigatório");
        }

        LojaModel model = loja.toModel();

        if (model.getCriadoEm() == null) {
            model.setCriadoEm(LocalDateTime.now());
        }

        LojaModel salvo = repository.save(model);
        logger.info("Loja salva com ID: {}", salvo.getIdLoja());
        return Loja.fromModel(salvo);
    }

    public List<Loja> listarTodas() {
        logger.info("Listando todas as lojas");
        return repository.findAll()
                .stream()
                .map(Loja::fromModel)
                .toList();
    }

    public Optional<Loja> buscarPorId(int id) {
        logger.info("Buscando loja por ID: {}", id);
        return repository.findById(id)
                .map(Loja::fromModel);
    }

    public boolean atualizar(int id, Loja lojaAtualizada) {
        logger.info("Atualizando loja ID: {}", id);

        if (!repository.existsById(id)) {
            logger.warn("Loja com ID {} não encontrada", id);
            return false;
        }

        LojaModel existente = repository.findById(id).orElseThrow();

        if (lojaAtualizada.getNome() != null && !lojaAtualizada.getNome().isEmpty()) {
            existente.setNome(lojaAtualizada.getNome());
        }

        if (lojaAtualizada.getCriadoEm() != null) {
            existente.setCriadoEm(lojaAtualizada.getCriadoEm());
        }

        repository.save(existente);
        logger.info("Loja atualizada com sucesso: ID {}", id);
        return true;
    }

    public boolean deletar(int id) {
        logger.info("Deletando loja ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Loja com ID {} não encontrada para deleção", id);
            return false;
        }

        repository.deleteById(id);
        logger.info("Loja deletada com sucesso: ID {}", id);
        return true;
    }
}