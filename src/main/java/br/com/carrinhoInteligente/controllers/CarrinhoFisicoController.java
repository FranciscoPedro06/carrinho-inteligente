package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.CarrinhoFisico;
import br.com.carrinhoInteligente.facades.CarrinhoFisicoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrinhoFisico")
public class CarrinhoFisicoController {

    private final CarrinhoFisicoFacade carrinhoFisicoFacade;

    @Autowired
    public CarrinhoFisicoController(CarrinhoFisicoFacade carrinhoFisicoFacade) {
        this.carrinhoFisicoFacade = carrinhoFisicoFacade;
    }

    // CREATE
    @PostMapping("/adicionar")
    public void salvar(@RequestBody CarrinhoFisico carrinho) {
        System.out.println("POST recebido: " + carrinho.getCodigoQr() + " | " + carrinho.getStatus() + " | " + carrinho.getCriadoEm());
        carrinhoFisicoFacade.salvar(carrinho);
    }


    // READ - Listar todos
    @GetMapping("/")
    public List<CarrinhoFisico> listarTodos() {
        return carrinhoFisicoFacade.listarTodos();
    }

    // READ - Buscar por ID
    @GetMapping("/{id}")
    public Optional<CarrinhoFisico> buscarPorId(@PathVariable int id) {
        return carrinhoFisicoFacade.buscarPorId(id);
    }

    // UPDATE
    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody CarrinhoFisico carrinho) {
        return carrinhoFisicoFacade.atualizar(id, carrinho);
    }

    // DELETE
    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return carrinhoFisicoFacade.deletar(id);
    }
}
