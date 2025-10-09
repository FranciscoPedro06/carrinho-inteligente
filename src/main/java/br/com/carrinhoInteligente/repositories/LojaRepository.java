package br.com.carrinhoInteligente.repositories;

import br.com.carrinhoInteligente.models.LojaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<LojaModel, Integer> {
}
