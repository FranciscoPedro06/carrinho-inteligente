package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoItem;
import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import br.com.carrinhoInteligente.models.CarrinhoItemModel;
import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import br.com.carrinhoInteligente.repositories.CarrinhoSessaoRepository;
import br.com.carrinhoInteligente.repositories.ClienteRepository;
import br.com.carrinhoInteligente.repositories.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoSessaoApplication {

    private final CarrinhoSessaoRepository repository;
    private final ClienteRepository clienteRepository;
    private final PagamentoRepository pagamentoRepository;


    public CarrinhoSessaoApplication(CarrinhoSessaoRepository repository, ClienteRepository clienteRepository, PagamentoRepository pagamentoRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.pagamentoRepository = pagamentoRepository;
    }


    public CarrinhoSessao salvar(CarrinhoSessao sessao) {
        CarrinhoSessaoModel model = sessao.toModel();

        // 🔗 Vincular Cliente
        if (model.getCliente().getIdCliente() != 0) {
            var cliente = clienteRepository.getReferenceById(model.getCliente().getIdCliente());
            model.setCliente(cliente);
        }

        // 🔗 Vincular Pagamento
        if (model.getPagamento().getId() != 0) {
            var pagamento = pagamentoRepository.getReferenceById(model.getPagamento().getId());
            model.setPagamento(pagamento);
        }

        CarrinhoSessaoModel salvo = repository.save(model);
        return CarrinhoSessao.fromModel(salvo);
    }


    public List<CarrinhoSessao> listarTodos() {
        return repository.findAll()
                .stream()
                .map(CarrinhoSessao::fromModel)
                .toList();
    }

    public Optional<CarrinhoSessao> buscarPorId(int id) {
        return repository.findById(id)
                .map(CarrinhoSessao::fromModel);
    }

    public boolean atualizar(int id, CarrinhoSessao sessao) {
        if (!repository.existsById(id)) {
            return false;
        }

        CarrinhoSessaoModel model = sessao.toModel();
        model.setId(id);

        // 🔗 Vincular Cliente
        if (model.getCliente().getIdCliente() != 0) {
            var cliente = clienteRepository.getReferenceById(model.getCliente().getIdCliente());
            model.setCliente(cliente);
        }

        // 🔗 Vincular Pagamento
        if (model.getPagamento().getId() != 0) {
            var pagamento = pagamentoRepository.getReferenceById(model.getPagamento().getId());
            model.setPagamento(pagamento);
        }

        repository.save(model);
        return true;
    }


    public boolean deletar(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}