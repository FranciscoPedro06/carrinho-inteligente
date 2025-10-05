package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.models.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoModel, Integer> {
}
