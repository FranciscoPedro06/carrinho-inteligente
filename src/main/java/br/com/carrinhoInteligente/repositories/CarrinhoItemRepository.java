package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.models.CarrinhoItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoItemRepository extends JpaRepository<CarrinhoItemModel, Integer> {
}
