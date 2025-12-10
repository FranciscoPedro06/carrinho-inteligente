package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Pagamento;
import br.com.carrinhoInteligente.models.PagamentoModel;
import br.com.carrinhoInteligente.repositories.PagamentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoApplication {

    private final PagamentoRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(PagamentoApplication.class);

    public PagamentoApplication(PagamentoRepository repository) {
        this.repository = repository;
    }

    public Pagamento salvar(Pagamento pagamento) {
        logger.info("Salvando pagamento: {}", pagamento);

        if (pagamento == null) {
            throw new IllegalArgumentException("Pagamento não pode ser nulo");
        }

        // Validação básica
        if (pagamento.getMetodo() == null || pagamento.getMetodo().trim().isEmpty()) {
            throw new IllegalArgumentException("Método de pagamento é obrigatório");
        }

        if (pagamento.getValor() == null || pagamento.getValor() <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser maior que zero");
        }

        PagamentoModel model = pagamento.toModel();

        // Definir valores padrão se não informados
        if (model.getCriadoEm() == null) {
            model.setCriadoEm(LocalDateTime.now());
        }

        if (model.getAtualizadoEm() == null) {
            model.setAtualizadoEm(LocalDateTime.now());
        }

        if (model.getStatus() == null || model.getStatus().isEmpty()) {
            model.setStatus("PENDENTE");
        }

        PagamentoModel salvo = repository.save(model);
        logger.info("Pagamento salvo com ID: {}", salvo.getId());
        return Pagamento.fromModel(salvo);
    }

    public List<Pagamento> listarTodos() {
        logger.info("Listando todos os pagamentos");
        return repository.findAll()
                .stream()
                .map(Pagamento::fromModel)
                .toList();
    }

    public Optional<Pagamento> buscarPorId(int id) {
        logger.info("Buscando pagamento por ID: {}", id);
        return repository.findById(id)
                .map(Pagamento::fromModel);
    }

    public boolean atualizar(int id, Pagamento pagamentoAtualizado) {
        logger.info("Atualizando pagamento ID: {}", id);

        if (!repository.existsById(id)) {
            logger.warn("Pagamento com ID {} não encontrado", id);
            return false;
        }

        PagamentoModel existente = repository.findById(id).orElseThrow();

        if (pagamentoAtualizado.getMetodo() != null && !pagamentoAtualizado.getMetodo().isEmpty()) {
            existente.setMetodo(pagamentoAtualizado.getMetodo());
        }

        if (pagamentoAtualizado.getValor() != null && pagamentoAtualizado.getValor() > 0) {
            existente.setValor(pagamentoAtualizado.getValor());
        }

        if (pagamentoAtualizado.getStatus() != null && !pagamentoAtualizado.getStatus().isEmpty()) {
            existente.setStatus(pagamentoAtualizado.getStatus());
        }

        if (pagamentoAtualizado.getCriadoEm() != null) {
            existente.setCriadoEm(pagamentoAtualizado.getCriadoEm());
        }

        existente.setAtualizadoEm(LocalDateTime.now());

        repository.save(existente);
        logger.info("Pagamento atualizado com sucesso: ID {}", id);
        return true;
    }

    public boolean deletar(int id) {
        logger.info("Deletando pagamento ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Pagamento com ID {} não encontrado para deleção", id);
            return false;
        }

        repository.deleteById(id);
        logger.info("Pagamento deletado com sucesso: ID {}", id);
        return true;
    }
}