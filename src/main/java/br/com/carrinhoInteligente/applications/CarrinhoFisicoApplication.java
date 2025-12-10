package br.com.carrinhoInteligente.applications;

import br.com.carrinhoInteligente.entities.CarrinhoFisico;
import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import br.com.carrinhoInteligente.models.LojaModel;
import br.com.carrinhoInteligente.repositories.CarrinhoFisicoRepository;
import br.com.carrinhoInteligente.repositories.CarrinhoSessaoRepository;
import br.com.carrinhoInteligente.repositories.LojaRepository;
import jakarta.persistence.EntityNotFoundException;
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

        // 1. Vincular loja (usando idLoja do carrinho)
        if (carrinho.getIdLoja() != 0) {
            try {
                LojaModel loja = lojaRepository.getReferenceById(carrinho.getIdLoja());
                model.setLoja(loja);
            } catch (EntityNotFoundException e) {
                throw new IllegalArgumentException("Loja com ID " + carrinho.getIdLoja() + " não encontrada");
            }
        }

        // 2. Vincular sessão (se existir)
        if (carrinho.getIdCarrinhoSessao() != 0) {
            try {
                CarrinhoSessaoModel sessao = sessaoRepository.getReferenceById(carrinho.getIdCarrinhoSessao());
                model.setCarrinhoSessao(sessao);
            } catch (EntityNotFoundException e) {
                throw new IllegalArgumentException("Sessão com ID " + carrinho.getIdCarrinhoSessao() + " não encontrada");
            }
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

        // Buscar o carrinho existente
        CarrinhoFisicoModel existente = repository.findById(id).orElseThrow();

        // Atualizar APENAS os campos que foram fornecidos (não nulos)
        if (novoCarrinho.getCodigoQr() != null) {
            existente.setCodigoQr(novoCarrinho.getCodigoQr());
        }

        if (novoCarrinho.getStatus() != null) {
            existente.setStatus(novoCarrinho.getStatus());
        }

        if (novoCarrinho.getCriadoEm() != null) {
            existente.setCriadoEm(novoCarrinho.getCriadoEm());
        }

        // Atualizar relacionamento com loja se fornecido (diferente de 0)
        if (novoCarrinho.getIdLoja() != 0) {
            try {
                LojaModel loja = lojaRepository.getReferenceById(novoCarrinho.getIdLoja());
                existente.setLoja(loja);
            } catch (EntityNotFoundException e) {
                throw new IllegalArgumentException("Loja com ID " + novoCarrinho.getIdLoja() + " não encontrada");
            }
        }

        // Atualizar relacionamento com sessão se fornecido (diferente de 0)
        if (novoCarrinho.getIdCarrinhoSessao() != 0) {
            try {
                CarrinhoSessaoModel sessao = sessaoRepository.getReferenceById(novoCarrinho.getIdCarrinhoSessao());
                existente.setCarrinhoSessao(sessao);
            } catch (EntityNotFoundException e) {
                throw new IllegalArgumentException("Sessão com ID " + novoCarrinho.getIdCarrinhoSessao() + " não encontrada");
            }
        }

        repository.save(existente);
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