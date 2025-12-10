package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoFisico;
import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import br.com.carrinhoInteligente.models.LojaModel;
import br.com.carrinhoInteligente.repositories.CarrinhoFisicoRepository;
import br.com.carrinhoInteligente.repositories.CarrinhoSessaoRepository;
import br.com.carrinhoInteligente.repositories.LojaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoFisicoApplication {

    private final CarrinhoFisicoRepository repository;
    private final LojaRepository lojaRepository;
    private final CarrinhoSessaoRepository sessaoRepository;

    public CarrinhoFisicoApplication(CarrinhoFisicoRepository repository, LojaRepository lojaRepository, CarrinhoSessaoRepository sessaoRepository) {
        this.repository = repository;
        this.lojaRepository = lojaRepository;
        this.sessaoRepository = sessaoRepository;
    }

    public CarrinhoFisico salvar(CarrinhoFisico carrinho) {
        CarrinhoFisicoModel model = carrinho.toModel();

        // 1. Vincular loja
        if (model.getLoja().getIdLoja() != 0) {
            LojaModel loja = lojaRepository.getReferenceById(model.getId());
            model.setLoja(loja);
        }

        // 2. Vincular sessão (se existir)
        if (model.getId()!= 0) {
            CarrinhoSessaoModel sessao = sessaoRepository.getReferenceById(model.getId());
            model.setCarrinhoSessao(sessao);
        }

        CarrinhoFisicoModel salvo = repository.save(model);
        return CarrinhoFisico.fromModel(salvo);
    }

    public List<CarrinhoFisico> listarTodos() {
        return repository.findAll()
                .stream()
                .map(CarrinhoFisico::fromModel)
                .toList();
    }

    public Optional<CarrinhoFisico> buscarPorId(int id) {
        return repository.findById(id)
                .map(CarrinhoFisico::fromModel);
    }

    public boolean atualizar(int id, CarrinhoFisico novoCarrinho) {
        if (!repository.existsById(id)) {
            return false;
        }

        CarrinhoFisicoModel model = novoCarrinho.toModel();
        model.setId(id);

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