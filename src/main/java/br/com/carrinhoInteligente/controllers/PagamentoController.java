package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Pagamento;
import br.com.carrinhoInteligente.facades.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PagamentoFacade pagamentoFacade;

    @Autowired
    public PagamentoController(PagamentoFacade pagamentoFacade) {
        this.pagamentoFacade = pagamentoFacade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody Pagamento pagamento) {
        pagamentoFacade.salvar(pagamento);
    }

    @GetMapping("/")
    public List<Pagamento> listarTodos() {
        return pagamentoFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pagamento> buscarPorId(@PathVariable int id) {
        return pagamentoFacade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody Pagamento pagamento) {
        return pagamentoFacade.atualizar(id, pagamento);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return pagamentoFacade.deletar(id);
    }
}
