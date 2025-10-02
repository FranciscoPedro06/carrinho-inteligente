package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.entities.Loja;
import br.com.carrinhoInteligente.facades.LojaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lojas")
public class LojaController {

    private final LojaFacade lojaFacade;

    @Autowired
    public LojaController(LojaFacade lojaFacade) {
        this.lojaFacade = lojaFacade;
    }

    @PostMapping("/adicionar")
    public void salvar(@RequestBody Loja loja) {
        lojaFacade.salvar(loja);
    }

    @GetMapping("/")
    public List<Loja> listarTodos() {
        return lojaFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Loja> buscarPorId(@PathVariable int id) {
        return lojaFacade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody Loja loja) {
        return lojaFacade.atualizar(id, loja);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return lojaFacade.deletar(id);
    }
}
