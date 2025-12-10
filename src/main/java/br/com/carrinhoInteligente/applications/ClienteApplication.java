package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.Cliente;
import br.com.carrinhoInteligente.models.ClienteModel;
import br.com.carrinhoInteligente.repositories.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteApplication {

    private final ClienteRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(ClienteApplication.class);

    public ClienteApplication(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente) {
        logger.info("Salvando cliente: {}", cliente);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }

        // Validação básica
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }

        ClienteModel model = cliente.toModel();

        // Define data de criação se não informada
        if (model.getCriadoEm() == null) {
            model.setCriadoEm(LocalDateTime.now());
        }

        ClienteModel salvo = repository.save(model);
        logger.info("Cliente salvo com ID: {}", salvo.getIdCliente());
        return Cliente.fromModel(salvo);
    }

    public List<Cliente> listarTodos() {
        logger.info("Listando todos os clientes");
        return repository.findAll()
                .stream()
                .map(Cliente::fromModel)
                .toList();
    }

    public Optional<Cliente> buscarPorId(int id) {
        logger.info("Buscando cliente por ID: {}", id);
        return repository.findById(id)
                .map(Cliente::fromModel);
    }

    public boolean atualizar(int id, Cliente clienteAtualizado) {
        logger.info("Atualizando cliente ID: {}", id);

        if (!repository.existsById(id)) {
            logger.warn("Cliente com ID {} não encontrado", id);
            return false;
        }

        // Buscar o cliente existente
        ClienteModel existente = repository.findById(id).orElseThrow();

        // Atualizar APENAS os campos que foram fornecidos (não nulos)
        if (clienteAtualizado.getNome() != null && !clienteAtualizado.getNome().isEmpty()) {
            existente.setNome(clienteAtualizado.getNome());
        }

        if (clienteAtualizado.getEmail() != null && !clienteAtualizado.getEmail().isEmpty()) {
            existente.setEmail(clienteAtualizado.getEmail());
        }

        if (clienteAtualizado.getTelefone() != null && !clienteAtualizado.getTelefone().isEmpty()) {
            existente.setTelefone(clienteAtualizado.getTelefone());
        }

        // Data de criação não deve ser alterada
        // Se quiser atualizar, pode adicionar um campo "atualizadoEm"

        repository.save(existente);
        logger.info("Cliente atualizado com sucesso: ID {}", id);
        return true;
    }

    public boolean deletar(int id) {
        logger.info("Deletando cliente ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Cliente com ID {} não encontrado para deleção", id);
            return false;
        }

        repository.deleteById(id);
        logger.info("Cliente deletado com sucesso: ID {}", id);
        return true;
    }
}