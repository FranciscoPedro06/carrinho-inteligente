package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import br.com.carrinhoInteligente.models.ClienteModel;
import br.com.carrinhoInteligente.models.PagamentoModel;
import br.com.carrinhoInteligente.repositories.CarrinhoSessaoRepository;
import br.com.carrinhoInteligente.repositories.ClienteRepository;
import br.com.carrinhoInteligente.repositories.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoSessaoApplication {

    private final CarrinhoSessaoRepository repository;
    private final ClienteRepository clienteRepository;
    private final PagamentoRepository pagamentoRepository;

    private static final Logger logger = LoggerFactory.getLogger(CarrinhoSessaoApplication.class);

    public CarrinhoSessaoApplication(CarrinhoSessaoRepository repository,
                                     ClienteRepository clienteRepository,
                                     PagamentoRepository pagamentoRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    public CarrinhoSessao salvar(CarrinhoSessao sessao) {
        logger.info("Salvando CarrinhoSessao: {}", sessao);

        CarrinhoSessaoModel model = sessao.toModel();

        // 🔥 VALORES PADRÃO PARA CAMPOS OBRIGATÓRIOS
        if (model.getCriadoEm() == null) {
            model.setCriadoEm(LocalDateTime.now());
        }

        if (model.getAtualizadoEm() == null) {
            model.setAtualizadoEm(LocalDateTime.now());
        }

        if (model.getStatus() == null || model.getStatus().isEmpty()) {
            model.setStatus("ABERTO");
        }

        // 🔗 Vincular Cliente (se fornecido) - OPCIONAL
        if (sessao.getIdCliente() != null && sessao.getIdCliente() != 0) {
            logger.info("Tentando vincular cliente com ID: {}", sessao.getIdCliente());
            try {
                ClienteModel cliente = clienteRepository.getReferenceById(sessao.getIdCliente());
                model.setCliente(cliente);
                logger.info("Cliente vinculado com sucesso: {}", cliente.getIdCliente());
            } catch (EntityNotFoundException e) {
                logger.error("Cliente não encontrado: {}", sessao.getIdCliente(), e);
                throw new IllegalArgumentException("Cliente com ID " + sessao.getIdCliente() + " não encontrado");
            }
        } else {
            logger.info("Nenhum cliente fornecido. Cliente será null.");
            model.setCliente(null); // Garante que seja null
        }

        // 🔗 Vincular Pagamento (se fornecido) - OPCIONAL
        if (sessao.getIdPagamento() != null && sessao.getIdPagamento() != 0) {
            logger.info("Tentando vincular pagamento com ID: {}", sessao.getIdPagamento());
            try {
                PagamentoModel pagamento = pagamentoRepository.getReferenceById(sessao.getIdPagamento());
                model.setPagamento(pagamento);
                logger.info("Pagamento vinculado com sucesso: {}", pagamento.getId());
            } catch (EntityNotFoundException e) {
                logger.error("Pagamento não encontrado: {}", sessao.getIdPagamento(), e);
                throw new IllegalArgumentException("Pagamento com ID " + sessao.getIdPagamento() + " não encontrado");
            }
        } else {
            logger.info("Nenhum pagamento fornecido. Pagamento será null.");
            model.setPagamento(null); // Garante que seja null
        }

        try {
            CarrinhoSessaoModel salvo = repository.save(model);
            logger.info("CarrinhoSessao salvo com ID: {}", salvo.getId());
            return CarrinhoSessao.fromModel(salvo);
        } catch (Exception e) {
            logger.error("Erro ao salvar CarrinhoSessao: ", e);
            // Verifica se é erro de constraint NOT NULL
            if (e.getMessage() != null && e.getMessage().contains("cannot be null")) {
                throw new IllegalArgumentException("Erro no banco de dados: Alguma coluna está como NOT NULL mas deveria permitir null. "
                        + "Execute: ALTER TABLE carrinho_sessao MODIFY COLUMN pagamento_id INT NULL;");
            }
            throw new RuntimeException("Erro ao salvar sessão do carrinho: " + e.getMessage(), e);
        }
    }

    public List<CarrinhoSessao> listarTodos() {
        logger.info("Listando todas as sessões do carrinho");
        return repository.findAll()
                .stream()
                .map(CarrinhoSessao::fromModel)
                .toList();
    }

    public Optional<CarrinhoSessao> buscarPorId(int id) {
        logger.info("Buscando sessão do carrinho por ID: {}", id);
        return repository.findById(id)
                .map(CarrinhoSessao::fromModel);
    }

    public boolean atualizar(int id, CarrinhoSessao novaSessao) {
        logger.info("Atualizando sessão do carrinho ID: {}", id);

        if (!repository.existsById(id)) {
            logger.warn("Sessão do carrinho com ID {} não encontrada", id);
            return false;
        }

        // Buscar a sessão existente
        CarrinhoSessaoModel existente = repository.findById(id).orElseThrow();

        // Atualizar APENAS os campos que foram fornecidos (não nulos)
        if (novaSessao.getStatus() != null && !novaSessao.getStatus().isEmpty()) {
            existente.setStatus(novaSessao.getStatus());
        }

        if (novaSessao.getTotal() != 0) {
            existente.setTotal(novaSessao.getTotal());
        }

        if (novaSessao.getCriadoEm() != null) {
            existente.setCriadoEm(novaSessao.getCriadoEm());
        }

        // Sempre atualiza o campo atualizadoEm
        existente.setAtualizadoEm(LocalDateTime.now());

        // 🔗 Atualizar Cliente (se fornecido)
        if (novaSessao.getIdCliente() != null) {
            if (novaSessao.getIdCliente() == 0) {
                // Se idCliente = 0, remove o cliente
                existente.setCliente(null);
                logger.info("Cliente removido da sessão");
            } else {
                try {
                    ClienteModel cliente = clienteRepository.getReferenceById(novaSessao.getIdCliente());
                    existente.setCliente(cliente);
                    logger.info("Cliente atualizado para ID: {}", novaSessao.getIdCliente());
                } catch (EntityNotFoundException e) {
                    throw new IllegalArgumentException("Cliente com ID " + novaSessao.getIdCliente() + " não encontrado");
                }
            }
        }

        // 🔗 Atualizar Pagamento (se fornecido)
        if (novaSessao.getIdPagamento() != null) {
            if (novaSessao.getIdPagamento() == 0) {
                // Se idPagamento = 0, remove o pagamento
                existente.setPagamento(null);
                logger.info("Pagamento removido da sessão");
            } else {
                try {
                    PagamentoModel pagamento = pagamentoRepository.getReferenceById(novaSessao.getIdPagamento());
                    existente.setPagamento(pagamento);
                    logger.info("Pagamento atualizado para ID: {}", novaSessao.getIdPagamento());
                } catch (EntityNotFoundException e) {
                    throw new IllegalArgumentException("Pagamento com ID " + novaSessao.getIdPagamento() + " não encontrado");
                }
            }
        }

        try {
            repository.save(existente);
            logger.info("Sessão do carrinho atualizada com sucesso: ID {}", id);
            return true;
        } catch (Exception e) {
            logger.error("Erro ao atualizar sessão do carrinho: ", e);
            throw new RuntimeException("Erro ao atualizar sessão do carrinho: " + e.getMessage(), e);
        }
    }

    public boolean deletar(int id) {
        logger.info("Deletando sessão do carrinho ID: {}", id);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            logger.info("Sessão do carrinho deletada com sucesso: ID {}", id);
            return true;
        }
        logger.warn("Sessão do carrinho com ID {} não encontrada para deleção", id);
        return false;
    }
}