package br.com.carrinhoInteligente.facades;

import br.com.carrinhoInteligente.applications.CarrinhoSessaoApplication;
import br.com.carrinhoInteligente.entities.CarrinhoSessao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarrinhoSessaoFacade {
    private final CarrinhoSessaoApplication application;
    private static final Logger logger = LoggerFactory.getLogger(CarrinhoSessaoFacade.class);

    public CarrinhoSessaoFacade(CarrinhoSessaoApplication application) {
        this.application = application;
        logger.info("CarrinhoSessaoFacade inicializado");
    }

    public CarrinhoSessao salvar(CarrinhoSessao sessao) {
        logger.info("Facade: Salvando CarrinhoSessao");
        return application.salvar(sessao);
    }

    public List<CarrinhoSessao> listarTodos() {
        logger.info("Facade: Listando todas as sessões");
        return application.listarTodos();
    }

    public Optional<CarrinhoSessao> buscarPorId(int id) {
        logger.info("Facade: Buscando sessão por ID: {}", id);
        return application.buscarPorId(id);
    }

    public boolean atualizar(int id, CarrinhoSessao sessao) {
        logger.info("Facade: Atualizando sessão ID: {}", id);
        return application.atualizar(id, sessao);
    }

    public boolean deletar(int id) {
        logger.info("Facade: Deletando sessão ID: {}", id);
        return application.deletar(id);
    }
}