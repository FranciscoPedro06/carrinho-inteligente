package br.com.carrinhoInteligente.controllers;

import br.com.carrinhoInteligente.facades.LojaFacade;
import br.com.carrinhoInteligente.models.LojaModel;
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
    public void salvar(@RequestBody LojaModel loja) {
        lojaFacade.salvar(loja);
    }

    @GetMapping("/")
    public List<LojaModel> listarTodos() {
        return lojaFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<LojaModel> buscarPorId(@PathVariable int id) {
        return lojaFacade.buscarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public boolean atualizar(@PathVariable int id, @RequestBody LojaModel loja) {
        return lojaFacade.atualizar(id, loja);
    }

    @DeleteMapping("/excluir/{id}")
    public boolean deletar(@PathVariable int id) {
        return lojaFacade.deletar(id);
    }
}
