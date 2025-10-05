package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.models.CarrinhoSessaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoSessaoRepository extends JpaRepository<CarrinhoSessaoModel, Integer> {
}
