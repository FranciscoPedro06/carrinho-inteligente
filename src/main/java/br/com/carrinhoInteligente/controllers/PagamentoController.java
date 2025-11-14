package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Pagamento;
import br.com.carrinhoInteligente.facades.PagamentoFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PagamentoFacade facade;

    public PagamentoController(PagamentoFacade facade) {
        this.facade = facade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody Pagamento pagamento) {
        facade.salvar(pagamento);
    }

    @GetMapping("/")
    public List<Pagamento> listarTodos() {
        return facade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pagamento> buscarPorId(@PathVariable int id) {
        return facade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody Pagamento pagamento) {
        return facade.atualizar(id, pagamento);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return facade.deletar(id);
    }
}
