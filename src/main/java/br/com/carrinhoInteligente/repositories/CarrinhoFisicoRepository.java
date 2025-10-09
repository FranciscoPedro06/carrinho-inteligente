package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.models.CarrinhoFisicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoFisicoRepository extends JpaRepository<CarrinhoFisicoModel, Integer> {
}
